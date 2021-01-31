# I know that this leads to "Time Limit Exceeded"
# However I liked this solution so I kept it here.

# Instead of checking if the s[:end] is a palindrome you should rather check
# if s starts with the reversed string of s

# def shortestPalindrome(self, s):
#     r = s[::-1]
#     for i in range(len(s) + 1):
#         if s.startswith(r[i:]):
#             return r[:i] + s

class Solution(object):
    def checkPalindrome(self, s):
        return s == s[::-1]

    def shortestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        end = len(s)
        if end == 0:
            return s
        while end > 0:
            if self.checkPalindrome(s[:end]):
                return s[end:][::-1] + s
            else:
                end = end - 1
