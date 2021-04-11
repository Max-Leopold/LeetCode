package main.ctci.ch1.question8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// O(nm) runtime, O(max(n,m)) space

public class Solution1 {

    static Integer[][] zeroMatrix(Integer[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        for (Integer i : rows) {
            zeroRow(matrix, i);
        }

        for (Integer i : columns) {
            zeroColumn(matrix, i);
        }

        return matrix;
    }

    private static void zeroRow(Integer[][] matrix, int row) {
        Arrays.fill(matrix[row], 0);
    }

    private static void zeroColumn(Integer[][] matrix, int column) {
        for (int i = 0; i < matrix[column].length; i++) {
            matrix[i][column] = 0;
        }
    }
}
