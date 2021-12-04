instructions = File.readlines(File.join(File.dirname(__FILE__), "input.txt"))

def calculate_ending_position(instructions)
    depth = 0
    horizontal_position = 0
    instructions.each do |instruction|
        instruction = instruction.split(" ")
        case instruction[0]
        when "forward"
            horizontal_position += instruction[1].to_i
        when "down"
            depth += instruction[1].to_i
        when "up"
            depth -= instruction[1].to_i
        end
    end

    return depth, horizontal_position
end

depth, horizontal_position = calculate_ending_position(instructions)
puts "Day 2, Part 1: #{depth * horizontal_position}"

def calculate_ending_position_with_aim(instructions)
    depth = 0
    horizontal_position = 0
    aim = 0
    instructions.each do |instruction|
        instruction = instruction.split(" ")
        case instruction[0]
        when "forward"
            horizontal_position += instruction[1].to_i
            depth += (instruction[1].to_i * aim)
        when "down"
            aim += instruction[1].to_i
        when "up"
            aim -= instruction[1].to_i
        end
    end

    return depth, horizontal_position
end

depth, horizontal_position = calculate_ending_position_with_aim(instructions)
puts "Day 2, Part 2: #{depth * horizontal_position}"