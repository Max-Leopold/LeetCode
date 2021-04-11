package main.ctci.ch1.question8;

import main.util.java.PrettyPrinter;

public class Main {

    public static void main(String[] args) {
        final PrettyPrinter prettyPrinter = new PrettyPrinter<Integer>(System.out);
        prettyPrinter.print(Solution1.zeroMatrix(new Integer[][]{
                {1, 0, 3},
                {4, 0, 6},
                {7, 8, 9}
        }));

        prettyPrinter.print(Solution2.zeroMatrix(new Integer[][]{
                {1, 0, 3},
                {4, 0, 6},
                {7, 8, 9}
        }));
    }
}
