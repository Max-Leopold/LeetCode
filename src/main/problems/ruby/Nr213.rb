# @param {Integer[]} nums
# @return {Integer}
def rob(nums)
    return nums.max if nums.size < 4

    [rob_range(nums, 0, nums.size - 2), rob_range(nums, 1, nums.size - 1)].max
end

def rob_range(nums, start, end_num, dp = [])
    prev_one, prev_two = [nums[start], nums[start + 1]].max, nums[start]

    ((start + 2)..end_num).each do |idx|
        prev_one, prev_two = [prev_one, prev_two + nums[idx]].max, prev_one
    end
    prev_one
end