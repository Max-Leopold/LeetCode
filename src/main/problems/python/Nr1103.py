from typing import List


class Solution:
	def distributeCandies(self, candies: int, num_people: int) -> List[int]:
		candies_list = [0] * num_people
		candies_counter = 0

		while candies > candies_counter:
			candies_list[candies_counter % num_people] += candies_counter + 1
			candies_counter += 1
			candies -= candies_counter

		candies_list[candies_counter % num_people] += candies
		return candies_list


if __name__ == '__main__':
	sol = Solution()
	print(sol.distributeCandies(7, 4))
