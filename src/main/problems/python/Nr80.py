class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length = 0
        seen = {}
        for i in range(len(nums)):
            if nums[i] in seen:
                if seen[nums[i]] == 2:
                    nums[i] = 10001
                else:
                    seen[nums[i]] += 1
                    length += 1
            else:
                seen[nums[i]] = 1
                length += 1

        nums.sort()
        return length
