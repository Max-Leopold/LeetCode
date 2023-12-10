input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp).map(&:chars)

MOVES = { "F" => [[1, 0], [0, 1]], "J" => [[-1, 0], [0, -1]], "7" => [[-1, 0], [0, 1]], "L" => [[1, 0], [0, -1]], "|" => [[0, 1], [0, -1]], "-" => [[1, 0], [-1, 0]]}

start = [input.transpose.index { _1.include?("S") }, input.index { _1.include?("S") }]
curr = [[-1, 0], [1, 0], [0, 1], [0, -1]].map { start.zip(_1).map(&:sum) }.find do |pos|
    MOVES[input[pos[1]][pos[0]]].map { pos.zip(_1).map(&:sum) }.include?(start)
end

prev, moves = start, 0
while curr != start
    prev, curr = curr, MOVES[input[curr[1]][curr[0]]].map { curr.zip(_1).map(&:sum) }.find { _1 != prev}
    moves += 1
end

pp (moves + 1) / 2 