package main.algorithms.sort;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(MergeSort.sort(new int[]{1, 3, 6, 21, 512, 6, 21, 41, 52, 531, 0}))
        );
    }
}
