require "Set"

input = File.readlines(File.join(File.dirname(__FILE__), "input.txt"), chomp: true)
antennas = input.flat_map.with_index { |line, y| line.chars.map.with_index { |c, x| c == "." ? nil : [c, Complex(x, y)] } }
  .compact.group_by(&:first).transform_values { |arr| arr.map(&:last) }

antinodes = Set.new
antennas.each { |_, pos| pos.combination(2).each { 
  distance = _1 - _2
  antinodes.merge([_1 + distance, _2 - distance])
} }

puts antinodes.select { _1.real.between?(0, input.first.size - 1) && _1.imaginary.between?(0, input.count - 1) }.count