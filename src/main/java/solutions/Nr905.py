from typing import List


class Solution:
	def sortArrayByParity(self, A: List[int]) -> List[int]:
		odd = []
		even = []
		for x in A:
			if x % 2 == 0:
				even.append(x)
			else:
				odd.append(x)

		return even + odd
