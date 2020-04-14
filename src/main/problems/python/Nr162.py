from typing import List


class Solution:
	def findPeakElement(self, nums: List[int]) -> int:
		if len(nums) == 1:
			return 0

		for i in range(len(nums)):
			if i == 0:
				if nums[i] > nums[i + 1]:
					return i
			elif i == len(nums) - 1:
				if nums[i] > nums[i - 1]:
					return i
			else:
				if nums[i] > nums[i - 1] and nums[i] > nums[i + 1]:
					return i

		return -1
