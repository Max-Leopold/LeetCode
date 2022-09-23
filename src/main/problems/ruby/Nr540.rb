# @param {Integer[]} nums
# @return {Integer}
def single_non_duplicate(nums)
    nums[bsearch(nums, 0, nums.size - 1)]
end


def bsearch(nums, left, right)
    while left < right - 1
        pivot = (left + right) / 2

        if (left + pivot).odd?
            if nums[pivot] == nums[pivot - 1]
                left = pivot + 1
            else
                right = pivot
            end
        else
            if nums[pivot] == nums[pivot - 1]
                right = pivot - 1
            else
                left = pivot
            end
        end
    end
    left
end