# @param {Integer[]} nums
# @return {Integer}
# [2,-5,-2,-4,3]
def max_product(nums)
    total_max = nums[0]
    pos, neg = nil, nil
    nums.reverse.each do |num|
        if num == 0
            total_max = 0 if total_max < 0
            pos, neg = nil, nil
        elsif num > 0
            new_pos = (pos || 1) * num
            neg = neg ? neg * num : nil
            pos = new_pos
        elsif num < 0
            new_neg = (pos || 1) * num
            pos = neg ? neg * num : nil
            neg = new_neg
        end
        total_max = pos if pos && pos > total_max
    end
    total_max
end

puts max_product([2,-5,-2,-4,3])