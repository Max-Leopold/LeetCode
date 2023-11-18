# @param {Integer[]} nums
# @param {Integer} k
# @return {Integer}
def max_frequency(nums, k)
    nums.sort!

    left = 0
    last_elem = nums[left]
    total_operations = 0
    max = 0

    nums.each_with_index do |elem, right|
        diff_to_last = elem - last_elem

        # We try to get all elements increased to the right element
        total_operations += (right - left) * diff_to_last

        # We move the left element as far to the right as necessary
        while total_operations > k
            total_operations -= nums[right] - nums[left]
            left += 1
        end

        last_elem = elem
        max = [max, right - left + 1].max
    end

    max
end

pp max_frequency([1,2,4], 5)