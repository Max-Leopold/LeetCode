from typing import List


class Solution:
	def maxProfit(self, prices: List[int]) -> int:
		stonks = 0
		for i in range(len(prices) - 1):
			if prices[i] < prices[i + 1]:
				stonks += prices[i + 1] - prices[i]

		return stonks
