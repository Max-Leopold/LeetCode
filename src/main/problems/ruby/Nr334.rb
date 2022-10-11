# @param {Integer[]} nums
# @return {Boolean}
def increasing_triplet(nums)
  return false if nums.size < 3

  min_one, min_two = nums[0], nil
  nums.each do |num|
    return true if num > (min_two || num)

    if num > min_one
      min_two = [min_two || num, num].min
    end
    if num < min_one
      min_one = num
    end
  end

  return false
end
