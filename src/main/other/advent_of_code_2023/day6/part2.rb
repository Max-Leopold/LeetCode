input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp)

time, distance = input.map { _1.scan(/\d+/).join.to_i }

def number_of_ways_to_beat(time, distance)
    disc = Math.sqrt(time ** 2 + 4 * -distance)
    ((-time - disc) / -2).ceil - (((-time + disc) / -2) + 1).floor
end

pp number_of_ways_to_beat(time, distance)