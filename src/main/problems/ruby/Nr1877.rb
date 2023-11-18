# @param {Integer[]} nums
# @return {Integer}
def min_pair_sum(nums)
    nums.sort!

    i = 0
    j = nums.length - 1
    max = nums[i] + nums[j]
    while i < j do
        max = [max, nums[i] + nums[j]].max
        i += 1
        j -= 1
    end

    max
end