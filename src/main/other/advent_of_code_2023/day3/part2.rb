require 'set'

input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp).map(&:chars)

COORDS = [-1, 0, 1].repeated_permutation(2)
LINE_LENGTH = input[0].size

gear_set = Set.new
input.each_with_index do |line, line_index|
    line.each_with_index do |char, char_index|
        gear_set.add(LINE_LENGTH * line_index + char_index) if char == "*"
    end
end

gear_map = Hash.new { |hsh, key| hsh[key] = [] }
input.each_with_index do |line, line_index|
    current_num, gears = 0, Set.new

    line.each_with_index do |char, char_index|
        if char.to_i.to_s == char
            current_num = current_num * 10 + char.to_i
            gears.merge(COORDS.map do |char_change, line_change|
                coord = LINE_LENGTH * (line_index + line_change) + (char_index + char_change)
                gear_set.include?(coord) ? coord : nil
            end.compact)
        elsif gears.size > 0
            gears.each { |gear| gear_map[gear] << current_num }

            current_num, gears = 0, Set.new
        else
            current_num, gears = 0, Set.new
        end
    end
    unless gears.empty?
        gears.each { |gear| gear_map[gear] << current_num }
    end
end

result = gear_map.values.select { |value| value.size == 2}.map { |nums| nums.inject(1, :*) }.sum
pp result