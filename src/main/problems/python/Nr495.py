from typing import List


class Solution:
	def findPoisonedDuration(self, timeSeries: List[int], duration: int) -> int:
		time_poisoned = 0

		if timeSeries:
			times = len(timeSeries)
			timeSeries.append(timeSeries[len(timeSeries) - 1] + duration)

			for i in range(times):
				time_poisoned += min(duration, timeSeries[i + 1] - timeSeries[i])

		return time_poisoned


if __name__ == '__main__':
	solr = Solution()
	print(solr.findPoisonedDuration([1, 4], 2))
