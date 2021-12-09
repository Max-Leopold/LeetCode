require 'set'

input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r")

def generate_heightmap(input)
    input.map{|line|
        line.chomp.split("").map(&:to_i)
    }
end

def calculate_risk_levels(heightmap)
    risk_level_with_basin_size = []
    (0...heightmap.length).each {|row|
        (0...heightmap[row].length).each {|column|
            if (row == 0 || heightmap[row - 1][column] > heightmap[row][column]) &&
                (row == heightmap.length - 1 || heightmap[row + 1][column] > heightmap[row][column]) &&
                (column == 0 || heightmap[row][column - 1] > heightmap[row][column]) &&
                (column == heightmap[row].length - 1 || heightmap[row][column + 1] > heightmap[row][column])
                risk_level_with_basin_size << [heightmap[row][column] + 1, calculate_basin_size(heightmap, row, column)]
            end
        }
    }
    risk_level_with_basin_size.transpose
end

def calculate_basin_size(heightmap, row, column)
    basin = 0
    visited = Set.new
    queue = Queue.new
    queue.push([row, column])

    while !queue.empty?
        row, column = queue.pop
        visited.add([row, column])
        if row > 0 && heightmap[row - 1][column] != 9 && !visited.include?([row - 1, column])
            queue.push([row - 1, column])
        end
        if row < heightmap.length - 1 && heightmap[row + 1][column] != 9 && !visited.include?([row + 1, column])
            queue.push([row + 1, column])
        end
        if column > 0 && heightmap[row][column - 1] != 9 && !visited.include?([row, column - 1])
            queue.push([row, column - 1])
        end
        if column < heightmap[row].length - 1 && heightmap[row][column + 1] != 9 && !visited.include?([row, column + 1])
            queue.push([row, column + 1])
        end
    end
    visited.length
end

heightmap = generate_heightmap(input)
risk_levels, basin_sizes = calculate_risk_levels(heightmap)

puts "Day 9, Part 1: Sum of risk levels: #{risk_levels.sum}"
puts "Day 9, Part 2: Product of 3 biggest basins: #{basin_sizes.max(3).inject(:*)}"