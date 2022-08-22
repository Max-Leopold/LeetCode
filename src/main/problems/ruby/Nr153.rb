# @param {Integer[]} nums
# @return {Integer}
def find_min(nums)
    left, right = 0, nums.size - 1

    while left < right
        pivot = (left + right) / 2

        if nums[right] > nums[pivot]
            right = pivot
        else
            left = pivot + 1
        end
    end

    nums[left]
end


puts find_min([2,3,1])