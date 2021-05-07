package main.problems.java;

import java.util.Arrays;
import java.util.HashMap;

public class Nr1636 {
    public static void main(String[] args) {
        Nr1636 nr1636 = new Nr1636();
        System.out.println(Arrays.toString(
                nr1636.frequencySort(new int[]{1, 1, 1, 2, 2, 2, 3})
        ));
    }

    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            counts.merge(nums[i], 1, (oldvalue, defaultvalue) -> oldvalue + 1);
        }
        return Arrays.stream(nums)
                .boxed()
                .sorted((a, b) -> {
                    int aCount = counts.get(a);
                    int bCount = counts.get(b);
                    if (aCount == bCount) {
                        return Integer.compare(b, a);
                    } else if (aCount > bCount) {
                        return 1;
                    } else {
                        return -1;
                    }
                }).mapToInt(x -> x)
                .toArray();
    }
}
