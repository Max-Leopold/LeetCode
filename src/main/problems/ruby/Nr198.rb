# @param {Integer[]} nums
# @return {Integer}
def rob(nums)
    return nums[0] if nums.size == 1

    nums[1] = [nums[0], nums[1]].max

    (2...nums.size).each do |idx|
        nums[idx] = [nums[idx] + nums[idx - 2], nums[idx - 1]].max
    end
    nums.last
end