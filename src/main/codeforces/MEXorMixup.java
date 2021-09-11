package main.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MEXorMixup {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int cases = sc.nextInt();

        for (int i = 0; i < cases; i++) {
            int mex = sc.nextInt();
            int xor = sc.nextInt();

            int arrayLength = mex;
            int num = calculateXor(mex - 1);

            if (num == xor) {
                System.out.println(arrayLength);
                continue;
            }

            int bitmask = num ^ xor;

            arrayLength = bitmask == mex ? arrayLength + 2 : arrayLength + 1;
            System.out.println(arrayLength);
        }
    }

    private static int calculateXor(int n) {
        int mod = n % 4;

        if (mod == 0) {
            return n;
        }

        if (mod == 1) {
            return 1;
        }

        if (mod == 2) {
            return n + 1;
        }

        if (mod == 3) {
            return 0;
        }

        throw new IllegalStateException("Unreachable");
    }
}
