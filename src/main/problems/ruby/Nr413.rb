# @param {Integer[]} nums
# @return {Integer}
def number_of_arithmetic_slices(nums)
  return 0 if nums.size < 3

  res = 0
  current_diff = 0
  subarray_size = 0
  nums.each_cons(2) do |first, second|
    diff = (first - second).abs
    if diff == current_diff
      subarray_size += 1
    else
      res += (0.5 * subarray_size ** 2 - 0.5 * subarray_size)
      current_diff = diff
      subarray_size = 1
    end
  end

  res += (0.5 * subarray_size ** 2 - 0.5 * subarray_size)
  res.to_i
end

puts number_of_arithmetic_slices([1,2,3,4,5])
