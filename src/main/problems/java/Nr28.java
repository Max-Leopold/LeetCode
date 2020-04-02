package main.problems.java;

/**
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part
 * of haystack.
 */

public class Nr28 {

  public static int strStr(String haystack, String needle) {
    if (needle == null || needle.equals("")) {
      return 0;
    }
    if(haystack == null || haystack.equals("")) {
      return -1;
    }

    int start = 0;
    int end = needle.length();

    while(end <= haystack.length()) {
      if(haystack.substring(start, end).equals(needle)) {
        return start;
      }

      start++;
      end++;
    }

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(strStr("a", "a"));
  }
}
