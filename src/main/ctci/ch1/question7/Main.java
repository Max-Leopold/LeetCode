package main.ctci.ch1.question7;

import main.util.java.PrettyPrinter;

public class Main {

    public static void main(String[] args) {
        final PrettyPrinter prettyPrinter = new PrettyPrinter<Integer>(System.out);
        prettyPrinter.print(Solution1.rotateMatrix(new Integer[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }));
    }
}
