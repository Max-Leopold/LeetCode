INPUT = File.readlines(File.join(File.dirname(__FILE__), "input.txt"), chomp: true).map(&:chars)

MOVES = [[1, 0], [-1, 0], [0, 1], [0, -1], [1, 1], [-1, -1], [1, -1], [-1, 1]]

def check_xmas(pos, move, remaining = "XMAS")
  return 1 if remaining.empty?
  return 0 if pos.any?(&:negative?) || INPUT[pos[1]]&.[](pos[0]) != remaining[0]
  check_xmas(pos.zip(move).map(&:sum), move, remaining[1...])
end

pp INPUT.each_with_index.sum { |line, y| line.each_with_index.sum {|_, x| MOVES.sum { |move| check_xmas([x, y], move) }}}