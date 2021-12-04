diagnostics = File.readlines(File.join(File.dirname(__FILE__), "input.txt")).map {|line| line.split("").map(&:to_i)[0...-1]}

def calculate_gamma_and_epsilon(diagnostics)
    gamma = diagnostics.transpose.map(&:sum).map {|sum|
        sum >= diagnostics.length / 2 ? 1 : 0
    }.join.to_i(2)
    return gamma, gamma ^ (1 << gamma.bit_length) - 1
end

gamma, epsilon = calculate_gamma_and_epsilon(diagnostics)
puts "Day 3, Part 1: Gamma #{gamma}, Epsilon #{epsilon}, Solution: #{gamma * epsilon}"


def select_diagostics_with_bit_at_position(diagnostics, bit, position)
    diagnostics.select {|diagnostic| diagnostic[position] == bit}
end

def calculate_life_support_ratings(diagnostics, position, comparator)
    sum = diagnostics.transpose.map(&:sum)
    bit_to_select = sum[position].public_send(comparator, diagnostics.length / 2.0) ? 1 : 0
    x = select_diagostics_with_bit_at_position(diagnostics, bit_to_select, position)
    return x[0].join.to_i(2) if x.length == 1
    calculate_life_support_ratings(x, position + 1, comparator)
end

def calculate_oxygen_and_co2(diagnostics)
    oxygen = calculate_life_support_ratings(diagnostics, 0, :>=)
    co2 = calculate_life_support_ratings(diagnostics, 0, :<)
    return oxygen, co2
end

oxygen, co2 = calculate_oxygen_and_co2(diagnostics)
puts "Day 3, Part 2: Oxygen: #{oxygen}, Co2: #{co2}, Solution: #{oxygen * co2}"