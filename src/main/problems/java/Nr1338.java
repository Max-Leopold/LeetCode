package main.problems.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Nr1338 {

    public static void main(String[] args) {
        Nr1338 nr1338 = new Nr1338();
        System.out.println(nr1338.minSetSize(new int[]{1000, 1000, 3, 7}));
    }

    public int minSetSize(int[] arr) {
        // Constraints say max number is 100000
        int[] counts = new int[100001];
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i]]++;
        }
        Arrays.sort(counts);
        int countOfNums = 0;
        int countOfOcc = 0;
        for (int i = counts.length - 1; i >= 0; i--) {
            countOfOcc++;
            countOfNums += counts[i];
            if (countOfNums >= arr.length / 2) {
                return countOfOcc;
            }
        }
        return countOfOcc;
    }

    // This is very slow but I wanted to play around with some streams
    public int minSetSizeStreams(int[] arr) {
        AtomicInteger countOfNums = new AtomicInteger();
        AtomicInteger countOfOcc = new AtomicInteger();
        Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(
                        x -> x,
                        Collectors.counting())
                ).values()
                .stream()
                .mapToInt(Long::intValue)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .forEach(i -> {
                    if (countOfNums.get() < arr.length / 2) {
                        countOfNums.getAndAdd(i);
                        countOfOcc.getAndIncrement();
                    }
                });

        return countOfOcc.get();
    }
}
