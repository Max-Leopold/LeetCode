package main.problems.java;

public class Nr8 {

  public int myAtoi(String str) {
    int result = 0;
    int lastRes = 0;
    boolean minus = false;

    //Inefficient solution using regex
    if (str.trim().length() == 0 || !str.trim().substring(0, 1).replaceAll("[(^\\d-+)]", "").equals("")) {
      return 0;
    }

    str = str.trim().replaceAll("(?<!^)\\D(.?)*", "");

    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (c == '-') {
        minus = true;
        continue;
      } else if (c == '+') {
        minus = false;
        continue;
      }

      if (minus) {
        result = result * 10 - Character.getNumericValue(c);
        if (result / 10 != lastRes) {
          return Integer.MIN_VALUE;
        }
        lastRes = result;
      } else {
        result = result * 10 + Character.getNumericValue(c);
        if (result / 10 != lastRes) {
          return Integer.MAX_VALUE;
        }
        lastRes = result;
      }
    }

    return result;
  }
}
