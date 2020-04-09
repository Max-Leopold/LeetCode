def createString(S: str) -> str:
	i = 0
	while i < len(S):
		if S[i] == '#' and i != 0:
			S = S[0:i - 1] + S[i + 1:]
			i -= 1
		elif S[i] == '#' and i == 0:
			S = S[1:]
		else:
			i += 1

	return S


class Solution:

	def backspaceCompare(self, S: str, T: str) -> bool:
		S = createString(S)
		T = createString(T)

		if T == S:
			return True
		else:
			return False


if __name__ == '__main__':
	print(createString(""))
