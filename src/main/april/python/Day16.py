class Solution:
	def checkValidString(self, s: str) -> bool:
		max_open = 0
		min_open = 0
		for c in s:
			if c == '(':
				min_open += 1
				max_open += 1
			if c == ')':
				min_open -= 1
				max_open -= 1
			if c == '*':
				min_open -= 1
				max_open += 1

			min_open = max(min_open, 0)
			if max_open < 0:
				return False
		if min_open == 0:
			return True
		else:
			return False


if __name__ == '__main__':
	sol = Solution()
	print(sol.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"))
	print(sol.checkValidString("(*()"))
