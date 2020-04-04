from typing import List


# Given an array nums, write a function to move all 0's to the end of it while
# maintaining the relative order of the non-zero elements.

class Solution:

	def moveZeroes(self, nums: List[int]) -> None:
		"""
		Do not return anything, modify nums in-place instead.
		"""

		i, j = 0, 0
		while i < len(nums):
			if nums[i] != 0:
				nums[j] = nums[i]
				j += 1
			i += 1
		while j < len(nums):
			nums[j] = 0
			j += 1


if __name__ == '__main__':
	sol = Solution()
	l = [0, 1, 0, 3, 12]
	sol.moveZeroes(l)
	print(l)
