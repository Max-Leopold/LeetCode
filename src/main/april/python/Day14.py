from typing import List


class Solution:
	def stringShift(self, s: str, shift: List[List[int]]) -> str:
		start = 0
		for a_shift in shift:
			if a_shift[0] == 0:
				start = start + a_shift[1]
			else:
				start = start - a_shift[1]

		start %= len(s)
		return s[start:] + s[:start]
