from typing import List


class Solution:
	def findMaxLength(self, nums: List[int]) -> int:

		max_length = 0
		ones_too_much = 0
		counter_dict = {0: -1}
		for i in range(len(nums)):
			if nums[i] == 1:
				ones_too_much += 1
			else:
				ones_too_much -= 1

			if ones_too_much in counter_dict:
				max_length = max(max_length, i - counter_dict[ones_too_much])
			else:
				counter_dict[ones_too_much] = i

		return max_length
