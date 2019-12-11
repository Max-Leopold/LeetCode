package solutions;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 */

public class Nr7 {

  public static int reverse(int x) {

    int result = 0;
    int prevResult = 0;

    while(x != 0){
      int lastDig = x % 10;
      x = x / 10;
      result = result * 10 + lastDig;
      if((result - lastDig) / 10 != prevResult) return 0;

      prevResult = result;
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(reverse(901000));
  }
}
