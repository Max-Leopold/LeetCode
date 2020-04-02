package main.problems.java;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 */

public class Nr4 {

  public static void main(String[] args) {
    Nr4 nr4 = new Nr4();
    double d = nr4.findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4});
    System.out.println(d);
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] mergedArrays = new int[nums1.length + nums2.length];
    int pointerA = 0;
    int pointerB = 0;

    while ((pointerA < nums1.length && pointerB < nums2.length)
        && (pointerA + pointerB) != mergedArrays.length / 2 + 1) {
      if (nums1[pointerA] < nums2[pointerB]) {
        mergedArrays[pointerA + pointerB] = nums1[pointerA];
        pointerA++;
      } else {
        mergedArrays[pointerA + pointerB] = nums2[pointerB];
        pointerB++;
      }
    }

    if (pointerA == nums1.length) {
      while (pointerB < nums2.length
          && (pointerA + pointerB) != mergedArrays.length / 2 + 1) {
        mergedArrays[pointerA + pointerB] = nums2[pointerB];
        pointerB++;
      }
    } else {
      while (pointerA < nums1.length
          && (pointerA + pointerB) != mergedArrays.length / 2 + 1) {
        mergedArrays[pointerA + pointerB] = nums1[pointerA];
        pointerA++;
      }
    }

    if (mergedArrays.length % 2 == 0) {
      return ((double) mergedArrays[mergedArrays.length / 2] + (double) mergedArrays[mergedArrays.length / 2 - 1]) / 2;
    } else {
      return mergedArrays[mergedArrays.length / 2];
    }
  }
}
