package main.ctci.ch1.question8;

import java.util.Arrays;

// O(nm) runtime, O(1) space

public class Solution2 {

    static Integer[][] zeroMatrix(Integer[][] matrix) {
        boolean firstRowHasZero = false;
        boolean firstColumHasZero = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColumHasZero = true;
                break;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                zeroRow(matrix, i);
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                zeroColumn(matrix, i);
            }
        }

        if (firstRowHasZero) {
            zeroRow(matrix, 0);
        }

        if (firstColumHasZero) {
            zeroColumn(matrix, 0);
        }

        return matrix;
    }

    private static void zeroRow(Integer[][] matrix, int row) {
        Arrays.fill(matrix[row], 0);
    }

    private static void zeroColumn(Integer[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }

}
