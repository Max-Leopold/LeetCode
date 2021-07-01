package main.problems.java;

import java.util.Arrays;

public class Nr1089 {
    public static void main(String[] args) {
        Nr1089 nr1089 = new Nr1089();
        nr1089.duplicateZeros(new int[]{
                1, 2, 0, 3, 0, 3
        });
    }

    public void duplicateZeros(int[] arr) {
        int zeroes = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) zeroes++;
        }

        int oldPos = arr.length - 1;
        int newPos = arr.length - 1 + zeroes;
        for (; oldPos < newPos; oldPos--, newPos--) {
            if (arr[oldPos] == 0) {
                setValue(arr, 0, newPos);
                newPos--;
                setValue(arr, 0, newPos);
            } else {
                setValue(arr, arr[oldPos], newPos);
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    private void setValue(int[] arr, int value, int index) {
        if (index > arr.length - 1) {
            return;
        }
        arr[index] = value;
    }
}
