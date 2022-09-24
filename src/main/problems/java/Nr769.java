package main.problems.java;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class Nr769 {
    public int maxChunksToSorted(int[] arr) {
        int max = -1;
        int maxChunks = 0;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            if (max == i) maxChunks++;
        }

        return maxChunks;
    }
}
