package main.problems.java;

import java.util.Arrays;

public class Nr329 {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] longestPaths = new int[matrix.length][matrix[0].length];
        int longestPath = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                longestPath = Math.max(
                        longestPath,
                        getLongestPath(matrix, i, j, longestPaths)
                );
            }
        }

        return longestPath;
    }

    private int getLongestPath(int[][] matrix, int row, int column, int[][] longestPaths) {
        if (longestPaths[row][column] != 0) return longestPaths[row][column];

        int longestPath = 1;
        int val = matrix[row][column];
        // Go Up
        if (row > 0 && matrix[row - 1][column] > val) {
            longestPath = Math.max(
                    longestPath,
                    getLongestPath(matrix, row - 1, column, longestPaths) + 1
            );
        }
        // Go Down
        if (row < matrix.length - 1 && matrix[row + 1][column] > val) {
            longestPath = Math.max(
                    longestPath,
                    getLongestPath(matrix, row + 1, column, longestPaths) + 1
            );
        }
        // Go Left
        if (column > 0 && matrix[row][column - 1] > val) {
            longestPath = Math.max(
                    longestPath,
                    getLongestPath(matrix, row, column - 1, longestPaths) + 1
            );
        }
        // Go Right
        if (column < matrix[0].length - 1 && matrix[row][column + 1] > val) {
            longestPath = Math.max(
                    longestPath,
                    getLongestPath(matrix, row, column + 1, longestPaths) + 1
            );
        }
        longestPaths[row][column] = longestPath;

        return longestPath;
    }
}
