package main.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MoamenAndKSubarrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int cases = sc.nextInt();

        for (int i = 0; i < cases; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }

            solve(arr, k);
        }
    }

    private static void solve(int[] arr, int k) {
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        Map<Integer, Integer> valueToCorrectPosition = new HashMap<>();
        for (int i = 0; i < sortedArr.length; i++) {
            valueToCorrectPosition.put(sortedArr[i], i);
        }
        int minSplits = 0;
        for (int i = 1; i < arr.length; i++) {
            if (valueToCorrectPosition.get(arr[i]) != valueToCorrectPosition.get(arr[i - 1]) + 1) {
                minSplits++;
            }
        }
        if (minSplits + 1 <= k) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
