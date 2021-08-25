package main.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SimplyStrangeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            int length = sc.nextInt();
            int[] array = new int[length];
            for (int j = 0; j < length; j++) {
                array[j] = sc.nextInt();
            }

            int iterations = solve(array);
            System.out.println(iterations);
        }
    }

    private static int solve(int[] arr) {
        int iterations = 0;
        while (!isSorted(arr)) {
            iterations++;
            if (iterations % 2 == 0) {
                for (int i = 1; i < arr.length - 1; i += 2) {
                    helper(arr, i);
                }
            } else {
                for (int i = 0; i < arr.length - 2; i += 2) {
                    helper(arr, i);
                }
            }
        }
        return iterations;
    }

    private static void helper(int[] arr, int i) {
        if (arr[i] > arr[i + 1]) {
            int tmp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = tmp;
        }
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
