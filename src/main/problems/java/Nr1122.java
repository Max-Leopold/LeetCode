package main.problems.java;

import java.util.Arrays;
import java.util.HashMap;

public class Nr1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> numPosMap = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            numPosMap.put(arr2[i], i);
        }
        return Arrays.stream(arr1)
                .boxed()
                .sorted((a, b) -> {
                    if (numPosMap.containsKey(a) && numPosMap.containsKey(b)) {
                        return numPosMap.get(a).compareTo(numPosMap.get(b));
                    } else if (numPosMap.containsKey(a)) {
                        return -1;
                    } else if (numPosMap.containsKey(b)) {
                        return 1;
                    } else {
                        return a.compareTo(b);
                    }
                })
                .mapToInt(i -> i)
                .toArray();
    }
}
