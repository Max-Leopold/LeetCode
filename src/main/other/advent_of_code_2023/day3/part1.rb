require 'set'

input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp).map(&:chars)

COORDS = [-1, 0, 1].repeated_permutation(2).to_a
LINE_LENGTH = input[0].size

symbols_set = Set.new
input.each_with_index do |line, line_index|
    line.each_with_index do |char, char_index|
        symbols_set.add(LINE_LENGTH * line_index + char_index) unless char.match?(/[0-9.]/)
    end
end

result = 0
input.each_with_index do |line, line_index|
    current_num, engine_part = 0, false
    line.each_with_index do |char, char_index| 
        if char.to_i.to_s == char
            current_num = current_num * 10 + char.to_i
            engine_part ||= COORDS.any? do |char_change, line_change|
                symbols_set.include?(LINE_LENGTH * (line_index + line_change) + (char_index + char_change))
            end
        else
            result += current_num if engine_part

            current_num, engine_part = 0, false
        end
    end
    result += current_num if engine_part
end

pp result 


