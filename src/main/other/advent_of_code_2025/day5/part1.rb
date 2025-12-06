intervals, nums = File.readlines(File.join(File.dirname(__FILE__), "input.txt"), chomp: true)
  .slice_before("").to_a
  .then do |(intervals, nums)|
    [
      intervals.map { |interval| Range.new(*interval.split("-").map(&:to_i)) },
      nums.drop(1).map(&:to_i)
    ]
  end

result = nums.count { |num| intervals.any? { |interval| interval === num } }

pp result