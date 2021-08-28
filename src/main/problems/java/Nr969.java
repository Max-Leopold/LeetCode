package main.problems.java;

import java.util.ArrayList;
import java.util.List;

public class Nr969 {
    public static void main(String[] args) {
        Nr969 nr969 = new Nr969();
        nr969.pancakeSort(new int[]{
                1, 2, 3
        });
    }

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> flips = new ArrayList<>();
        for (int i = arr.length; i > 1; i--) {
            int index = findNum(arr, i);
            flips.add(index + 1);
            flips.add(i);
            flip(arr, index + 1);
            flip(arr, i);
        }

        return flips;
    }

    private void flip(int[] arr, int k) {
        for (int i = 0; i < k / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[k - i - 1];
            arr[k - i - 1] = tmp;
        }
    }

    private int findNum(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }

        throw new IllegalArgumentException();
    }
}

