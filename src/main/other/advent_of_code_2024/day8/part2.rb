require "Set"

input = File.readlines(File.join(File.dirname(__FILE__), "input.txt"), chomp: true)
antennas = input.flat_map.with_index { |line, y| line.chars.map.with_index { |c, x| c == "." ? nil : [c, Complex(x, y)] } }
  .compact.group_by(&:first).transform_values { |arr| arr.map(&:last) }

antinodes = Set.new
antennas.each { |_, pos| pos.combination(2).each { |first_antenna, second_antenna|
  distance = first_antenna - second_antenna
  [:+, :-].each do |operator|
    pos = first_antenna
    while(pos.real.between?(0, input.first.size - 1) && pos.imaginary.between?(0, input.count - 1)) do
      antinodes.add(pos)
      pos = pos.send(operator, distance)
    end
  end
} }

puts antinodes.count