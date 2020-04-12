import bisect
from typing import List


class Solution:
	def lastStoneWeight(self, stones: List[int]) -> int:
		stones = sorted(stones)
		while len(stones) > 1:
			size = len(stones)
			new_stone = abs(stones.pop(size - 1) - stones.pop(size - 2))
			if new_stone != 0:
				bisect.insort(stones, new_stone)

		if stones:
			return stones.pop(0)
		else:
			return 0


if __name__ == '__main__':
	sol = Solution()
	print(sol.lastStoneWeight([2, 7, 4, 1, 8, 1]))
