# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer}
def three_sum_closest(nums, target)
  nums.sort!

  closest_sum = 1 / 0.0
  nums.each_with_index do |num, idx|
    low = idx + 1
    high = nums.size - 1
    while low < high
      current_sum = num + nums[low] + nums[high]
      return current_sum if current_sum == target

      closest_sum = (target - current_sum).abs < (target - closest_sum).abs ? current_sum : closest_sum

      if current_sum > target
        high -= 1
      else
        low += 1
      end
    end
  end

  closest_sum
end
