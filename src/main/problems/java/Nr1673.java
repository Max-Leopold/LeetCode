package main.problems.java;

import java.util.Arrays;
import java.util.Stack;

public class Nr1673 {
    public int[] mostCompetitive(int[] nums, int k) {
        if (nums.length == k) return nums;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && stack.peek() > nums[i] && stack.size() + nums.length - i > k) {
                stack.pop();
            }
            if (stack.size() < k) stack.push(nums[i]);
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}

/*# @param {Integer[]} nums
        # @param {Integer} k
        # @return {Integer[]}
        def most_competitive(nums, k)
        return nums if k == nums.size

        res = []
        last_idx = -1
        nums.each_with_index do |num, idx|
        elements_after = nums.size - 1 - idx
        max_idx = elements_after >= k ? 0 : k - elements_after - 1

        (max_idx...k).each do |replace_idx|
        curr_elem = res[replace_idx] || (1 / 0.0)
        if num < curr_elem || replace_idx > last_idx
        res[replace_idx] = num
        last_idx = replace_idx
        break
        end
        end
        end

        res
        end*/
