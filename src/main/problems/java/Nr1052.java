package main.problems.java;

public class Nr1052 {
    public static void main(String[] args) {
        Nr1052 nr1052 = new Nr1052();
        System.out.println(nr1052.maxSatisfied(
                new int[]{4, 10, 10},
                new int[]{1, 1, 0},
                2
        ));
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int alreadyUsedNonGrumpy = 0;
        int notUsedNonGrumpy = 0;
        int currentGrumpyValue = 0;

        for (int i = 0; i < customers.length; i++) {
            if (i >= minutes) {
                if (grumpy[i - minutes] == 1) {
                    currentGrumpyValue -= customers[i - minutes];
                }
            }
            if (grumpy[i] == 1) {
                currentGrumpyValue += customers[i];
            }
            if (grumpy[i] == 0) {
                notUsedNonGrumpy += customers[i];
                alreadyUsedNonGrumpy += customers[i];
            }
            alreadyUsedNonGrumpy = Math.max(alreadyUsedNonGrumpy, notUsedNonGrumpy + currentGrumpyValue);
        }
        return alreadyUsedNonGrumpy;
    }
}
