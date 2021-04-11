package main.ctci.ch1.question7;

// Mirror along X and diagonal degree angle = 90 degree rotation

public class Solution1 {

    public static Integer[][] rotateMatrix(Integer[][] matrix) {
        mirrorAlongX(matrix);
        mirrorAlongDiagonal(matrix);
        return matrix;
    }

    private static void mirrorAlongX(Integer[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            // We could save memory by only putting a single int in tmp and not the whole line
            Integer[] tmp = matrix[i];
            matrix[i] = matrix[matrix.length - 1 - i];
            matrix[matrix.length - 1 - i] = tmp;
        }
    }

    private static void mirrorAlongDiagonal(Integer[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                Integer tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
