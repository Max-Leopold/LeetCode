from typing import List


class Solution:
	def productExceptSelf(self, nums: List[int]) -> List[int]:
		output = [1]
		current_val = nums[0]
		for i in range(1, len(nums)):
			output.append(current_val)
			current_val *= nums[i]

		current_val = nums[len(nums) - 1]
		for i in range(len(nums) - 2, -1, -1):
			output[i] *= current_val
			current_val *= nums[i]

		return output


if __name__ == '__main__':
	sol = Solution()
	print(sol.productExceptSelf([4, 3, 2, 1, 2]))
