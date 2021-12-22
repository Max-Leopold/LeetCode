require_relative 'reactor'

input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r")

reactor = Reactor.new
input.each {|line|
    operation, coordinates = line.chomp.split(" ")
    x, y, z = coordinates.split(",").map {|coord| coord[2..-1].split("..").map(&:to_i)}
    case operation
    when "on"
        reactor.turn_on_cuboid(*x, *y, *z)
    when "off"
        reactor.turn_off_cuboid(*x, *y, *z)
    end
}

puts reactor.on_cubes.length
(-1..2).each {|a| puts a}
