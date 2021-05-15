package main.problems.java;

import java.util.ArrayList;
import java.util.Arrays;

public class Nr350 {

    public static void main(String[] args) {
        Nr350 nr350 = new Nr350();
        System.out.println(
                Arrays.toString(
                        nr350.intersect(
                                new int[]{1, 2, 2, 1},
                                new int[]{2, 2}
                        )
                )
        );
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList<>();
        // Could be replaced with Map
        int[] counter = new int[1001];
        for (int i = 0; i < nums1.length; i++) {
            counter[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            if (counter[nums2[i]] > 0) {
                result.add(nums2[i]);
                counter[nums2[i]]--;
            }
        }
        // Could be replaced with for loop
        return result.stream().mapToInt(x -> x).toArray();
    }


    // This is me misunderstanding the question and actually returning an intersection...
    /*
    public int[] intersect(int[] nums1, int[] nums2) {
        int bestStart = 0, bestEnd = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int maxDis = getMaxIntersectionFromIndex(
                        nums1,
                        nums2,
                        i,
                        j
                );
                if (maxDis > bestEnd - bestStart) {
                    bestStart = i;
                    bestEnd = i + maxDis;
                }
            }
        }
        int[] intersect = new int[bestEnd - bestStart];
        int counter = 0;
        for (int i = bestStart; i < bestEnd; i++) {
            intersect[counter] = nums1[i];
            counter++;
        }
        return intersect;
    }

    private int getMaxIntersectionFromIndex(
            int[] nums1,
            int[] nums2,
            int pointerNums1,
            int pointerNums2
    ) {
        int counter = 0;
        while (pointerNums1 < nums1.length
                && pointerNums2 < nums2.length) {
            if (nums1[pointerNums1] == nums2[pointerNums2]) {
                counter++;
            } else {
                return counter;
            }
            pointerNums1++;
            pointerNums2++;
        }
        return counter;
    } */
}
