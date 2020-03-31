package main.java.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array A of 0s and 1s, consider N_i: the i-th subarray from A[0] to A[i] interpreted
 * as a binary number (from most-significant-bit to least-significant-bit.)
 * <p>
 * Return a list of booleans answer, where answer[i] is true if and only if N_i is divisible by 5.
 */

public class Nr1018 {

  public static List<Boolean> prefixesDivBy5(int[] A) {

    int res = 0;
    List<Boolean> list = new ArrayList<>();
    for (int prefix : A) {
      res = (res * 2 + prefix) % 5;

      if (res == 0) {
        list.add(Boolean.TRUE);
      } else {
        list.add(Boolean.FALSE);
      }
    }

    return list;
  }

  public static void main(String[] args) {
    System.out.println(prefixesDivBy5(new int[] {0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1}));
  }
}
