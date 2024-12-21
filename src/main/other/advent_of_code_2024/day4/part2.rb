INPUT = File.readlines(File.join(File.dirname(__FILE__), "input.txt"), chomp: true).map(&:chars)

def check_x_mas(x, y)
  return 0 unless INPUT[y][x] == "A"
  ["M", "S"].permutation.any? { INPUT[y - 1][x - 1] == _1 && INPUT[y + 1][x + 1] == _2} &&
  ["M", "S"].permutation.any? { INPUT[y - 1][x + 1] == _1 && INPUT[y + 1][x - 1] == _2} ? 1 : 0
end

pp (1...(INPUT.size - 1)).sum { |y| (1...(INPUT[y].size - 1)).sum { |x| check_x_mas(x, y) } }