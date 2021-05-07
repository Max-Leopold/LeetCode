package main.problems.java;

import java.util.Arrays;

public class Nr838 {
    public static void main(String[] args) {
        Nr838 nr838 = new Nr838();
        System.out.println(nr838.pushDominoes(".L.R...LR..L.."));
        System.out.println(nr838.pushDominoesMoreEfficient(".L.R."));
    }

    public String pushDominoesMoreEfficient(String dominoes) {
        int lastSeenR = -1, lastSeenL = -1;
        char[] dominoesArray = dominoes.toCharArray();
        for (int i = 0; i < dominoesArray.length; i++) {
            if (dominoesArray[i] == 'R') {
                if (lastSeenL < lastSeenR) {
                    for (int j = lastSeenR + 1; j < i; j++) {
                        dominoesArray[j] = 'R';
                    }
                }

                lastSeenR = i;
            } else if (dominoesArray[i] == 'L') {
                if (lastSeenR > lastSeenL) {
                    int lo = lastSeenR + 1;
                    int hi = i - 1;
                    while (lo < hi) {
                        dominoesArray[lo] = 'R';
                        dominoesArray[hi] = 'L';
                        lastSeenR = lo;
                        lo++;
                        hi--;
                    }
                } else if (lastSeenR <= lastSeenL) {
                    for (int j = lastSeenL + 1; j < i; j++) {
                        dominoesArray[j] = 'L';
                    }
                }

                lastSeenL = i;
            }
        }
        if (lastSeenR > lastSeenL) {
            for (int j = lastSeenR + 1; j < dominoesArray.length; j++) {
                dominoesArray[j] = 'R';
            }
        }
        return new String(dominoesArray);
    }

    // This just calculates the dominoes at every step
    public String pushDominoes(String dominoes) {
        char[] dominoesArray = dominoes.toCharArray();
        char[] writeDominoesArray = dominoes.toCharArray();
        int operationsLastRun;
        do {
            operationsLastRun = 0;
            for (int i = 0; i < dominoesArray.length; i++) {
                if (dominoesArray[i] == 'L') {
                    if (i > 0) {
                        if (i == 1 && dominoesArray[0] == '.') {
                            writeDominoesArray[0] = 'L';
                            operationsLastRun++;
                        } else {
                            if (dominoesArray[i - 1] == '.' && dominoesArray[i - 2] != 'R') {
                                writeDominoesArray[i - 1] = 'L';
                                operationsLastRun++;
                            }
                        }
                    }
                } else if (dominoesArray[i] == 'R') {
                    if (i < dominoesArray.length - 1) {
                        if (i == dominoesArray.length - 2 && dominoesArray[dominoesArray.length - 1] == '.') {
                            writeDominoesArray[dominoesArray.length - 1] = 'R';
                            operationsLastRun++;
                        } else {
                            if (dominoesArray[i + 1] == '.' && dominoesArray[i + 2] != 'L') {
                                writeDominoesArray[i + 1] = 'R';
                                operationsLastRun++;
                                i++;
                            }
                        }
                    }
                }
            }
            dominoesArray = Arrays.copyOf(writeDominoesArray, writeDominoesArray.length);
        } while (operationsLastRun != 0);
        return new String(dominoesArray);
    }
}
