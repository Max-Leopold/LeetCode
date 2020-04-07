from typing import List


class Solution:
	def countElements(self, arr: List[int]) -> int:
		nums = set()
		a = 0
		arr.sort(reverse=True)
		for x in arr:
			nums.add(x)
			if x + 1 in nums:
				a += 1

		return a
