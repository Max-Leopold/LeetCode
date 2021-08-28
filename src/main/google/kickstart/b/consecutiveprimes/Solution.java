package main.google.kickstart.b.consecutiveprimes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        long cases = in.nextLong();
        for (long i = 0; i < cases; i++) {
            long z = in.nextLong();
            System.out.println("Case #" + (i + 1) + ": " + solve(z));
        }
    }

    private static long solve(long z) {
        long sqrt = (long) Math.sqrt(z);
        long firstSmallerPrime = findPrimeFromDown(sqrt);
        long maxPrime = z / firstSmallerPrime;
        long possibleSecondPrime = findPrimeFromUpToMax(sqrt + 1, maxPrime);
        if (possibleSecondPrime != -1 && possibleSecondPrime * firstSmallerPrime <= z) {
            return possibleSecondPrime * firstSmallerPrime;
        } else {
            long secondPrime = findPrimeFromDown(firstSmallerPrime - 1);
            return secondPrime * firstSmallerPrime;
        }
    }

    private static long findPrimeFromDown(long i) {
        for (; i > 0; i--) {
            if (isPrime(i)) {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }

    private static long findPrimeFromUpToMax(long i, long max) {
        for (; i <= max; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isPrime(long i) {
        long sqrt = (long) Math.sqrt(i);
        for (long j = 2; j <= sqrt; j++) {
            if (i % j == 0) return false;
        }
        return true;
    }
}
