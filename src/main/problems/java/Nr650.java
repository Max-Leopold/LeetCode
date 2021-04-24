package main.problems.java;

public class Nr650 {

    public int minSteps(int n) {
        int[] stepsToNumber = new int[n + 1];

        for (int i = 2; i < stepsToNumber.length; i++) {
            stepsToNumber[i] = i;
            for (int j = i / 2; j > 1; j--) {
                if (i % j == 0) {
                    // j now is the greatest divisor of i
                    stepsToNumber[i] = stepsToNumber[j] + (i / j);
                    break;
                }
            }
        }

        return stepsToNumber[n];
    }
}
