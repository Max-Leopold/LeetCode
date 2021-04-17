package main.ctci.ch16.question17;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(
                Solution1.contiguosSequence(new int[]{2, -8, 3, -2, 4, -10})
        );

        System.out.println(
                Arrays.toString(
                        Solution2.contiguosSequence(new int[]{2, -8, 3, -2, 4, -10})
                )
        );
    }
}
