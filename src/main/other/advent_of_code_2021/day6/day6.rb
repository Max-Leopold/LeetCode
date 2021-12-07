input = File.open(File.join(File.dirname(__FILE__), "input.txt"), &:readline).split(",").map(&:to_i).tally

def simulate(initial_state, days)
    fish_at8 = 0
    fish_at7 = 0
    (0...days).each {
        reproducing_fish = initial_state[0]
        initial_state = initial_state.rotate(1)
        initial_state[6] += fish_at7
        fish_at7 = fish_at8
        fish_at8 = reproducing_fish 
    }
    return initial_state.sum + fish_at7 + fish_at8
end

initial_state = Array.new(7, 0)
input.each {|key, value|
    initial_state[key] = value
}

puts "Day 6 Part 1: After 80 days #{simulate(initial_state, 80)} lanternfish exist"
puts "Day 6 Part 2: After 256 days #{simulate(initial_state, 256)} lanternfish exist"