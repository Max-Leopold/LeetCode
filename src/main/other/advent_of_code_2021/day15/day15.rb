require 'rb_heap'
require 'set'

input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map {|line| line.chomp.split("").map(&:to_i)}

Point = Struct.new(:risk_level, :neighbours) 
Node = Struct.new(:cost, :point)

def create_graph(grid)
    grid = grid.map {|row| row.map{|p| Point.new(p, [])}}
    (0...grid.length).each {|i|
        (0...grid[i].length).each {|j|
            grid[i][j].neighbours << grid[i + 1][j] if i < grid.length - 1
            grid[i][j].neighbours << grid[i - 1][j] if i > 0
            grid[i][j].neighbours << grid[i][j + 1] if j < grid[i].length - 1
            grid[i][j].neighbours << grid[i][j - 1] if j > 0
        }
    }
    return grid[0][0], grid[-1][-1]
end

def djikstra(start_point, end_point)
    node_heap = Heap.new {|a, b| a.cost < b.cost}
    node_heap << Node.new(0, start_point)
    visited = Set.new(start_point)
    until node_heap.peak.point == end_point || node_heap.empty?
        current_node = node_heap.pop
        current_node.point.neighbours.each {|neighbour|
            node_heap << Node.new(current_node.cost + neighbour.risk_level, neighbour) unless visited.include?(neighbour)
            visited << neighbour
        }
    end
    node_heap.peak.cost
end

start_point, end_point = create_graph(input)
min_cost = djikstra(start_point, end_point)
puts min_cost
