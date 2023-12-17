require "Set"
input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp).map(&:chars)

def energized(q, field)
    v = Set.new
    until q.empty?
        pos, dir = q.pop 
        next if v.include?([pos, dir]) || !(pos[0].between?(0, field.first.size - 1) && pos[1].between?(0, field.size - 1))
        v.add([pos, dir])
        case field[pos[1]][pos[0]]
        when "-" then [[1, 0], [-1, 0]]
        when "|" then [[0, 1], [0, -1]]
        when "/" then [[-dir[1], -dir[0]]]
        when "\\" then [[dir[1], dir[0]]]
        else [dir]
        end.each { q << [pos.zip(_1).map(&:sum), _1] }
    end
    v.map { _1.first(1) }.to_set.size
end

start_dir = [[1, 0], [-1, 0], [0, 1], [0, -1]]
top_and_bottom = (0...input.first.size).map { [[_1, 0], [_1, input.size - 1]] }.flatten(1)
left_and_right = (0...input.size).map { [[0, _1], [input.first.size - 1, _1]] }.flatten(1)

pp (top_and_bottom + left_and_right).product(start_dir).map(&:flatten).map { energized([[_1[..1], _1[2..]]], input) }.max