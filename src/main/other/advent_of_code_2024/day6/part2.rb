require "Set"

INPUT = File.readlines(File.join(File.dirname(__FILE__), "input.txt"), chomp: true).map(&:chars)
pos = INPUT.index { _1.include?("^") }.then { |y| Complex(INPUT[y].index("^"), y) }

def is_loop?(pos, additional_obst, seen = Set.new, dir = Complex(0, -1))
  loop do
    dir_pos = pos + dir 
    return false unless dir_pos.real.between?(0, INPUT.first.count - 1) && dir_pos.imaginary.between?(0, INPUT.count - 1)
    if INPUT[dir_pos.imaginary][dir_pos.real] == "#" || dir_pos == additional_obst
      dir = dir * Complex(0, 1)
    else
      return true if seen.include?([pos, dir])
      seen.add([pos, dir])
      pos = dir_pos
    end
  end
end

pp (0...INPUT.size).sum { |y| (0...INPUT[y].size).count { is_loop?(pos, Complex(_1, y)) } }