require_relative 'reactor'

def execute_operations(operations, reactor)
    operations.each {|line|
        operation, coordinates = line.chomp.split(" ")
        x, y, z = coordinates.split(",").map {|coord| coord[2..-1].split("..").map(&:to_i)}
        # Increment x´, y´ and z´ by one because my implementation is checking cuboids as [x, x2)
        x[1] += 1
        y[1] += 1
        z[1] += 1
        case operation
        when "on"
            reactor.turn_on_cuboid([*x, *y, *z])
        when "off"
            reactor.turn_off_cuboid([*x, *y, *z])
        end
    }
end

input_part1 = File.open(File.join(File.dirname(__FILE__), "part1-input.txt"), "r")
reactor_part1 = Reactor.new
execute_operations(input_part1, reactor_part1)

puts "Day 22, Part 1: After the initialization process there are #{reactor_part1.total_lights_on} lights on"

input_part2 = File.open(File.join(File.dirname(__FILE__), "part2-input.txt"), "r")
reactor_part2 = Reactor.new
execute_operations(input_part2, reactor_part2)

puts "Day 22, Part 1: After the full reboot process there are #{reactor_part2.total_lights_on} lights on"
