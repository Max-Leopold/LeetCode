input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp).map(&:chars)

BENDS = { "F" => [-1, -1], "J" => [1, 1], "7" => [1, -1], "L" => [-1, 1]}

def resolve(curr, prev, char)
    if move = BENDS[char]
        char = prev[1] != curr[1] ? "-" : "|"
        prev = prev.zip(move).map(&:sum)
    end
    curr.zip(char == "-" ? [prev[0] > curr[0] ? -1 : 1, 0] : [0, prev[1] > curr[1] ? -1 : 1]).map(&:sum)
end

start = [input.transpose.index { _1.include?("S") }, input.index { _1.include?("S") }]
current_pos = [[[-1, 0], "-FL"], [[1, 0], "-7J"], [[0, -1], "|7F"], [[0, 1], "|LJ"]].filter_map do |d, v|
    m_pos = start.zip(d).map(&:sum)
    m_pos if v.include?(input[m_pos[1]]&.[](m_pos[0]))
end.first

prev_pos, moves = start, 0
while current_pos != start
    prev_pos, current_pos = current_pos, resolve(current_pos, prev_pos, input[current_pos[1]][current_pos[0]])
    moves += 1
end

pp (moves + 1) / 2 