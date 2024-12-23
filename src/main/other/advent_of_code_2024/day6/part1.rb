require "Set"

input = File.readlines(File.join(File.dirname(__FILE__), "input.txt"), chomp: true).map(&:chars)
pos, seen, dir = input.index { _1.include?("^") }
  .then { |y| [Complex(input[y].index("^"), y), Set.new, Complex(0, -1)] }

while !seen.include?([pos, dir]) 
 dir_pos = pos + dir 
 break unless dir_pos.real.between?(0, input.first.count - 1) && dir_pos.imaginary.between?(0, input.count - 1)
 if input[dir_pos.imaginary][dir_pos.real] == "#"
    dir = dir * Complex(0, 1)
 else
    seen.add([pos, dir])
    pos = dir_pos
 end
end

pp seen.map { _1.first }.uniq.count + 1