package main.java.solutions;

public class Nr9 {

  public static void main(String[] args) {
    Nr9 nr9 = new Nr9();
    System.out.println(nr9.isPalindrome(10));
  }

  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }

    if (x == 0) {
      return true;
    }

    int reversed = 0;
    int start = x;

    while (start > reversed && x != 0) {
      reversed = reversed * 10 + x % 10;
      x /= 10;
    }

    if (reversed == start || reversed / 10 == start) {
      return true;
    }


    return false;
  }

}
