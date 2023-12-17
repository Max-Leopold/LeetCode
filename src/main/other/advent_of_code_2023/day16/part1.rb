require "Set"

input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp).map(&:chars)

q, v = [[[0, 0], [1, 0]]], Set.new
until q.empty?
    pos, dir = q.pop 
    next if v.include?([pos, dir]) || !(pos[0].between?(0, input.first.size - 1) && pos[1].between?(0, input.size - 1))
    v.add([pos, dir])
    case input[pos[1]][pos[0]]
    when "-" then [[1, 0], [-1, 0]]
    when "|" then [[0, 1], [0, -1]]
    when "/" then [[-dir[1], -dir[0]]]
    when "\\" then [[dir[1], dir[0]]]
    else [dir]
    end.each { q << [pos.zip(_1).map(&:sum), _1] }
end

pp v.map { _1.first(1) }.to_set.size