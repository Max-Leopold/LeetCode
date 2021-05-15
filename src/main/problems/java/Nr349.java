package main.problems.java;

import java.util.HashSet;
import java.util.Set;

public class Nr349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
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
}
