depths = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r") .map(&:to_i)


def get_increased_depths(depths)
    counter = 0
    previous_depth = -1

    depths.each do |depth|
        counter += 1 if depth > previous_depth && previous_depth > 0
        previous_depth = depth
    end

    counter
end

puts "Day 1, Part 1: #{get_increased_depths(depths)}"

def get_increased_depths_with_window(depths, window)
    sliding_window = Array.new(window)
    window_sum = 0
    depth_increases = 0

    depths.each_with_index do |depth, index|
        if index < window
            sliding_window[index] = depth
            window_sum += depth
        else 
            new_window_sum = window_sum - sliding_window[index % window] + depth
            depth_increases += 1 if new_window_sum > window_sum
            sliding_window[index % window] = depth
        end
    end

    depth_increases
end

puts "Day 1, Part 2: #{get_increased_depths_with_window(depths, 3)}"