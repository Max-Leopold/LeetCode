package main.problems.java;

public class Nr5 {

    public static void main(String[] args) {
        Nr5 nr5 = new Nr5();
        System.out.println(nr5.longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int nonLetterCenter = expandAroundCenter(s, i, i + 1);
            int letterCenter = expandAroundCenter(s, i, i);
            int maxLength = Math.max(nonLetterCenter, letterCenter);
            if (maxLength > end - start) {
                start = i - (maxLength - 1) / 2;
                end = i + maxLength / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (
                left >= 0
                        && right < s.length()
                        && s.charAt(left) == s.charAt(right)
        ) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
