input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp).map { _1.split(" ").last.split("")[2...-1] }

dirs = { "0" => Complex(1, 0), "2" => Complex(-1, 0), "3" => Complex(0, 1), "1" => Complex(0, -1) }
pos = Complex(0, 0)
boundary_points = input.sum { _1[...-1].join.to_i(16) }
area = input.sum do |hex|
    prev_pos, pos = pos, pos + dirs[hex.last] * hex[...-1].join.to_i(16)
    (prev_pos.imaginary + pos.imaginary) * (prev_pos.real - pos.real)
end.abs / 2

res = area + boundary_points / 2 + 1
pp res