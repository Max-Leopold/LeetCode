from typing import List


class Solution:
	def maxSubArray(self, nums: List[int]) -> int:
		fast_pointer = 0
		max_sub_array = nums[0]
		current_max_sub_array = 0
		while fast_pointer < len(nums):
			current_max_sub_array += nums[fast_pointer]
			fast_pointer += 1
			max_sub_array = max(max_sub_array, current_max_sub_array)

			if current_max_sub_array < 0:
				current_max_sub_array = 0

		return max_sub_array


if __name__ == '__main__':
	sol = Solution()
	print(sol.maxSubArray([-1]))
