input = File.open(File.join(File.dirname(__FILE__), "input.txt"), &:readline).chomp

def convert_to_binary(hex_string)
    hex_string.hex.to_s(2).rjust(hex_string.size * 4, '0')
end

def get_packet_version(binary_string)
    return binary_string[3..-1], binary_string[0...3].to_i(2)
end

def get_type_id(binary_string)
    return binary_string[3..-1], binary_string[0...3].to_i(2)
end

def get_length_type_id(binary_string)
    return binary_string[1..-1], binary_string[0].to_i
end

def get_length_of_subpackets(binary_string)
    return binary_string[15..-1], binary_string[0...15].to_i(2)
end

def get_subpackets_amount(binary_string)
    return binary_string[11..-1], binary_string[0...11].to_i(2)
end

def get_literal_value(binary_string)
    group_values = []
    until binary_string[0] == "0"
        binary_string, five_bit_group = binary_string[5..-1], binary_string[0...5]
        five_bit_group = five_bit_group[1..-1]
        group_values << five_bit_group
    end
    binary_string, five_bit_group = binary_string[5..-1], binary_string[0...5]
    five_bit_group = five_bit_group[1..-1]
    group_values << five_bit_group

    return binary_string, group_values.join.to_i(2)
end

def calculate_version_sum(binary_string)
    return 0, "" if binary_string.nil? || binary_string.length == 0

    puts "Initial binary String"
    puts binary_string
    puts

    binary_string, packet_version = get_packet_version binary_string
    puts "Calculated packet version"
    puts binary_string
    puts packet_version
    puts

    binary_string, type_id = get_type_id binary_string
    puts "Calculate type id"
    puts binary_string
    puts type_id
    puts

    # if type_id == 4 it's an literal value package
    if type_id == 4
        binary_string, literal_value = get_literal_value binary_string
        puts "Calculated literal value"
        puts binary_string
        puts literal_value
        puts
        # subpackets_version_sum, remainder = calculate_version_sum(binary_string)

        return packet_version, binary_string
    else # if a operator package
        binary_string, length_type_id = get_length_type_id binary_string
        puts "Calculated length type"
        puts binary_string
        puts length_type_id
        puts

        # if length_type_id == 0 then next 15 bits represent length of subpackets
        if length_type_id == 0
            binary_string, subpackets_length = get_length_of_subpackets binary_string
            puts "Calculated subpackets length"
            puts binary_string
            puts subpackets_length
            puts

            total_subpackets_version_sum, remainder = calculate_version_sum(binary_string[0...subpackets_length])
            while remainder != ""
                subpackets_version_sum, remainder = calculate_version_sum(remainder)
                total_subpackets_version_sum += subpackets_version_sum
            end

            return packet_version + total_subpackets_version_sum, binary_string[subpackets_length..-1]
        end

        # if length_type_id == 1 then next 11 bits number of subpackets contained by this package
        if length_type_id == 1
            binary_string, subpackets_amount = get_subpackets_amount binary_string
            puts "Calculated subpackets amount"
            puts binary_string
            puts subpackets_amount
            puts

            total_subpackets_version_sum = 0
            (0...subpackets_amount).each {|i|
                subpackets_version_sum, remainder = calculate_version_sum(binary_string)
                total_subpackets_version_sum += subpackets_version_sum
                binary_string = remainder
            }

            return packet_version + total_subpackets_version_sum, binary_string
        end
    end
end

def calculate_package_value(binary_string)
    return 0, "" if binary_string.nil? || binary_string.length == 0

    puts "Initial binary String"
    puts binary_string
    puts

    binary_string, packet_version = get_packet_version binary_string
    puts "Calculated packet version"
    puts binary_string
    puts packet_version
    puts

    binary_string, type_id = get_type_id binary_string
    puts "Calculate type id"
    puts binary_string
    puts type_id
    puts


    # if type_id == 4 it's an literal value package
    if type_id == 4
        binary_string, literal_value = get_literal_value binary_string
        puts "Calculated literal value"
        puts binary_string
        puts literal_value
        puts
        # subpackets_version_sum, remainder = calculate_version_sum(binary_string)

        return literal_value, binary_string
    else # if a operator package
        binary_string, length_type_id = get_length_type_id binary_string
        puts "Calculated length type"
        puts binary_string
        puts length_type_id
        puts
        subpacket_values = []

        # if length_type_id == 0 then next 15 bits represent length of subpackets
        if length_type_id == 0
            binary_string, subpackets_length = get_length_of_subpackets binary_string
            puts "Calculated subpackets length"
            puts binary_string
            puts subpackets_length
            puts

            subpacket_value, remainder = calculate_package_value(binary_string[0...subpackets_length])
            subpacket_values << subpacket_value
            while remainder != ""
                subpacket_value, remainder = calculate_package_value(remainder)
                subpacket_values << subpacket_value
            end

            puts "Subpacket values #{subpacket_values}"
            puts

            packet_value = case type_id
            when 0
                subpacket_values.sum
            when 1
                subpacket_values.inject(:*)
            when 2
                subpacket_values.min
            when 3
                subpacket_values.max
            when 5
                subpacket_values.first > subpacket_values.last ? 1 : 0
            when 6
                subpacket_values.first < subpacket_values.last ? 1 : 0
            when 7
                subpacket_values.first == subpacket_values.last ? 1 : 0
            end

            return packet_value, binary_string[subpackets_length..-1]
        end

        # if length_type_id == 1 then next 11 bits number of subpackets contained by this package
        if length_type_id == 1
            binary_string, subpackets_amount = get_subpackets_amount binary_string
            puts "Calculated subpackets amount"
            puts binary_string
            puts subpackets_amount
            puts

            (0...subpackets_amount).each {|i|
                subpacket_value, remainder = calculate_package_value(binary_string)
                puts "Value of ##{i} subpacket is #{subpacket_value}"
                puts
                subpacket_values << subpacket_value
                binary_string = remainder
            }

            puts "Subpacket values #{subpacket_values}"
            puts

            packet_value = case type_id
            when 0
                subpacket_values.sum
            when 1
                subpacket_values.inject(:*)
            when 2
                subpacket_values.min
            when 3
                subpacket_values.max
            when 5
                subpacket_values.first > subpacket_values.last ? 1 : 0
            when 6
                subpacket_values.first < subpacket_values.last ? 1 : 0
            when 7
                subpacket_values.first == subpacket_values.last ? 1 : 0
            end

            return packet_value, binary_string
        end
    end
end

binary_string = convert_to_binary input

version_sum =  calculate_version_sum binary_string
packet_value = calculate_package_value binary_string
puts "Day 16, Part 1: Sum of all (sub)packet versions: #{version_sum.first}"
puts "Day 16, Part 2: Packet value: #{packet_value.first}"

