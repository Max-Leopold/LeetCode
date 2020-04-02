from typing import List


class Solution:
	def maxArea(self, height: List[int]) -> int:
		max_water = 0
		back = len(height) - 1
		front = 0

		while back > front:
			max_water = max(max_water, (min(height[back], height[front]) * (back - front)))
			if height[back] < height[front]:
				back -= 1
			else:
				front += 1

		return max_water


if __name__ == '__main__':
	solution = Solution()
	wallList = [1, 8, 6, 2, 5, 4, 8, 3, 7]
	print(solution.maxArea(wallList))
