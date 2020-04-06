import collections
from typing import List


class Solution:
	def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
		return_list = collections.defaultdict(list)
		for word in strs:
			return_list[tuple(sorted(word))].append(word)
		return return_list.values()


if __name__ == '__main__':
	sol = Solution()
	print(sol.groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))
