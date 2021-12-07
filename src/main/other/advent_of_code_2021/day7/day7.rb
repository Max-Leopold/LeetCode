input = File.open(File.join(File.dirname(__FILE__), "example_input.txt"), &:readline).split(",").map(&:to_i)

# The median can be calculated in O(n) using quickselect but since the input is rather small
# O(nlogn) is sufficient here
def calculate_median(arr)
    arr.sort[arr.length / 2]
end

def calculate_mean(arr)
    (arr.sum(0.0) / arr.length)
end

median = calculate_median(input)
puts "Day 7 Part 1: The crab need a minimum of #{input.map {|position| (position - median).abs}.sum} fuel to align at the same position"

mean = calculate_mean(input)
# When thinking about the solution for part 2 I was pretty sure that the optimal position
# had to be the mean. The mean for my input is 478.567. I've rounded this up to 479
# and calculated the fuel costs. It turns out that this solution was wrong. So I've plugged
# in a couple of numbers smaller and bigger than the mean and it turns out the best position
# is actually `(mean +- 0.5).round`. By simply checking the solutions for mean.ceil and mean.floor
# we should always find the minimal cost.
# Here is a proof https://www.reddit.com/r/adventofcode/comments/rar7ty/2021_day_7_solutions/hnkbtug/
min_fuel = [
    input.map {|position| (0..(position - mean.ceil).abs).sum}.sum, 
    input.map {|position| (0..(position - mean.floor).abs).sum}.sum
].min
puts "Day 7 Part 2: The crab need a minimum of #{min_fuel} fuel to align at the same position"