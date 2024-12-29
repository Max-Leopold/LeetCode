input = File.readlines(File.join(File.dirname(__FILE__), "input.txt"), chomp: true)
  .map { _1.scan(/p=(\d+),(\d+)\sv=(-?\d+),(-?\d+)/).first.map(&:to_i) }

final_positions = input.map { |x, y, dx, dy| [(x + 100 * dx) % 101, (y + 100 * dy) % 103] }
  .select { |x, y| x != 50 && y != 51}
  .group_by { |x, y| [x < 50, y < 51]}
  .map { |k, v| v.count}.reduce(:*)

pp final_positions