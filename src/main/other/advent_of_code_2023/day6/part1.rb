input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp)

times, distances = input.map { _1.scan(/\d+/).map(&:to_i) }

def number_of_ways_to_beat(time, distance)
    disc = Math.sqrt(time ** 2 + 4 * -distance)
    (((-time - disc) / -2)).ceil - (((-time + disc) / -2) + 1).floor
end

result = times.zip(distances).map { number_of_ways_to_beat(_1, _2) }.reduce(1, :*)

pp result