from typing import List


class Solution:
	def twoSum(self, nums: List[int], target: int) -> List[int]:
		num_dict = {}
		for i in range(len(nums)):
			if target - nums[i] in num_dict:
				return [i, num_dict[target - nums[i]]]
			num_dict[nums[i]] = i
