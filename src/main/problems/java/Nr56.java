package main.problems.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Nr56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> mergedIntervals = new ArrayList<>();
        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > currentEnd) {
                mergedIntervals.add(new int[]{currentStart, currentEnd});
                currentStart = intervals[i][0];
            }
            currentEnd = Math.max(intervals[i][1], currentEnd);
        }
        mergedIntervals.add(new int[]{currentStart, currentEnd});

        return mergedIntervals.toArray(new int[0][]);
    }
}
