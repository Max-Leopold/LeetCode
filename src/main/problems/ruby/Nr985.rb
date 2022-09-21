# @param {Integer[]} nums
# @param {Integer[][]} queries
# @return {Integer[]}
def sum_even_after_queries(nums, queries)
  even_sum = nums.select(&:even?).sum

  queries.map do |val, index|
    even_sum -= nums[index] if nums[index].even?
    nums[index] += val
    even_sum += nums[index] if nums[index].even?
    even_sum
  end
end
