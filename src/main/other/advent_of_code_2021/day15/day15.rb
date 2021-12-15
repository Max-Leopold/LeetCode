require 'priority_queue'
require 'set'

grid = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map {|line| line.chomp.split("").map(&:to_i)}

def neighbours(row, column, grid)
    neighbours = []
    neighbours << [row + 1, column] if row + 1 < grid.length
    neighbours << [row - 1, column] if row - 1 >= 0
    neighbours << [row, column + 1] if column + 1 < grid[row].length
    neighbours << [row, column - 1] if column - 1 >= 0
    neighbours
end

def djikstra(start_point, end_point, grid)
    p_queue = PriorityQueue.new
    p_queue[start_point] = 0
    visited = Set.new(start_point)
    until p_queue.min_key == end_point || p_queue.empty?
        current_pos, risk_level = p_queue.delete_min
        neighbours(current_pos.first, current_pos.last, grid).each {|neighbour|
            p_queue[neighbour] = risk_level + grid[neighbour.first][neighbour.last] unless visited.include? neighbour
            visited << neighbour
        }
    end
    p_queue.min.last
end

min_cost = djikstra([0, 0], [grid.length - 1, grid[grid.length - 1].length - 1], grid)
puts "Day 15, Part 1: The minimal risk level to travel from top left to bottom right is #{min_cost}"

super_grid = (grid.map {|row| row * 5} * 5).map.with_index(0) {|row, i|
    row.map.with_index(0) {|value, j|
        row_offset = i / grid.length
        column_offset = j / grid[0].length
        value += row_offset + column_offset
        value > 9 ? value % 9 : value
    }
}
min_cost = djikstra([0, 0], [super_grid.length - 1, super_grid[super_grid.length - 1].length - 1], super_grid)
puts "Day 15, Part 2: The minimal risk level to travel from top left to the bottom right (using the x5 grid) is #{min_cost}"
