class Solution:
	def isHappy(self, n: int) -> bool:
		s = set()

		while n not in s:
			s.add(n)
			l = list(map(int, str(n)))
			n = 0
			for i in l:
				n += i ** 2
			if n == 1:
				return True

		return False
