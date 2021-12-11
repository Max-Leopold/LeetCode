energy_levels = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map {|line| line.chomp.split("").map(&:to_i)}

class Octopus
    
    attr_reader :flashed, :energy_level

    def initialize(energy_level)
        @energy_level = energy_level
        
        @neighbours = []
        @flashed = false
    end

    def reset
        if @flashed
            @flashed = false
            @energy_level = 0
        end
    end

    def add_neighbour(octopus)
        @neighbours << octopus unless octopus.nil?
    end

    def increase_power_level
        @energy_level += 1
        if !@flashed && @energy_level > 9
            @flashed = true
            @neighbours.each(&:increase_power_level)
        end
    end

end

def create_octopus_grid(energy_levels)
    octopus_grid = energy_levels.map {|energy_level_row|
        energy_level_row.map {|energy_level| Octopus.new energy_level}
    } 
    (0...octopus_grid.length).each do |i|
        (0...octopus_grid[i].length).each do |j|
            octopus_grid[i][j].add_neighbour(octopus_grid[i - 1][j]) if i > 0
            octopus_grid[i][j].add_neighbour(octopus_grid[i + 1][j]) if i < octopus_grid.length - 1
            octopus_grid[i][j].add_neighbour(octopus_grid[i][j - 1]) if j > 0
            octopus_grid[i][j].add_neighbour(octopus_grid[i][j + 1])
            
            # Diagonal
            octopus_grid[i][j].add_neighbour(octopus_grid[i + 1][j + 1]) if i < octopus_grid.length - 1
            octopus_grid[i][j].add_neighbour(octopus_grid[i - 1][j + 1]) if i > 0
            octopus_grid[i][j].add_neighbour(octopus_grid[i + 1][j - 1]) if i < octopus_grid.length - 1 && j > 0
            octopus_grid[i][j].add_neighbour(octopus_grid[i - 1][j - 1]) if i > 0 && j > 0
        end
    end
    octopus_grid
end

def simulate_step(octopus_grid) 
    octopus_grid.each {|octopus_row|
        octopus_row.each(&:increase_power_level)
    }
    flashed = octopus_grid.map {|octopus_row|
        octopus_row.select(&:flashed).count
    }.sum
    octopus_grid.each {|octopus_row|
        octopus_row.each(&:reset)
    }
    flashed
end

def simulate_steps(octopus_grid, steps) 
    (0...steps).map {
        simulate_step octopus_grid
    }.sum
end

def simulate_until_all_flash(octopus_grid)
    steps = 0
    while simulate_step(octopus_grid) != 100
        steps += 1
    end
    steps + 1
end

octopus_grid_part1 = create_octopus_grid energy_levels
octopus_grid_part2 = create_octopus_grid energy_levels

puts "Day 11, Part 1: After 100 steps #{simulate_steps(octopus_grid_part1, 100)} flashed."
puts "Day 11, Part 2: After #{simulate_until_all_flash(octopus_grid_part2)} steps all octopus flashed at the same time."