input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp).map { _1.split(" ") }

dirs = { "R" => Complex(1, 0), "L" => Complex(-1, 0), "U" => Complex(0, 1), "D" => Complex(0, -1) }
pos = Complex(0, 0)
boundary_points = input.sum{ _2.to_i }
area = input.sum do |dir, l|
    prev_pos, pos = pos, pos + dirs[dir] * l.to_i
    (prev_pos.imaginary + pos.imaginary) * (prev_pos.real - pos.real)
end.abs / 2

res = area + boundary_points / 2 + 1
pp res