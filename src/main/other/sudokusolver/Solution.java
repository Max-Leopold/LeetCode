package main.other.sudokusolver;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] toSolve = new int[][]{
                {0, 0, 0, 9, 0, 8, 3, 0, 0},
                {0, 8, 0, 0, 1, 0, 0, 0, 2},
                {0, 0, 0, 0, 3, 0, 6, 0, 0},
                {6, 0, 0, 1, 0, 0, 0, 4, 3},
                {0, 2, 0, 0, 7, 0, 0, 6, 0},
                {0, 3, 0, 0, 0, 5, 0, 0, 9},
                {0, 0, 1, 0, 9, 0, 0, 0, 0},
                {5, 0, 0, 0, 6, 0, 0, 8, 0},
                {0, 0, 4, 7, 0, 3, 0, 0, 0}
        };

        solution.solveSudoku(
                        /*new int[][]{
                                {0, 3, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 1, 9, 5, 0, 0, 0},
                                {0, 0, 8, 0, 0, 0, 0, 6, 0},
                                {8, 0, 0, 0, 6, 0, 0, 0, 0},
                                {4, 0, 0, 8, 0, 0, 0, 0, 1},
                                {0, 0, 0, 0, 2, 0, 0, 0, 0},
                                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                                {0, 0, 0, 0, 0, 0, 0, 7, 0}
                        },
                        */
                toSolve,
                0,
                0
        );
        for (int i = 0; i < toSolve.length; i++) {
            System.out.println(Arrays.toString(toSolve[i]));
        }
    }

    public boolean solveSudoku(int[][] grid, int row, int column) {
        for (int i = 0; i < grid[row].length; i++) {
            boolean solved;
            if (grid[row][i] == 0) {
                for (int j = 1; j <= 9; j++) {
                    grid[row][i] = j;
                    if (fitsInRow(grid, row, i)
                            && fitsInColumn(grid, row, i)
                            && fitsInSquare(grid, row, i)
                    ) {
                        if (i == grid[i].length - 1 && row < grid.length - 1) {
                            solved = solveSudoku(grid, row + 1, 0);
                        } else {
                            solved = solveSudoku(grid, row, column + 1);
                        }
                        if (solved) {
                            return true;
                        }
                    }
                }
                grid[row][i] = 0;
                return false;
            }
        }
        if (row == grid.length - 1) {
            return true;
        } else {
            return solveSudoku(grid, row + 1, 0);
        }
    }

    public boolean fitsInRow(int[][] grid, int row, int column) {
        int num = grid[row][column];
        for (int i = 0; i < grid[row].length; i++) {
            if (i == column) {
                continue;
            } else if (grid[row][i] == num) {
                return false;
            }
        }
        return true;
    }

    public boolean fitsInColumn(int[][] grid, int row, int column) {
        int num = grid[row][column];
        for (int i = 0; i < grid.length; i++) {
            if (i == row) {
                continue;
            } else if (grid[i][column] == num) {
                return false;
            }
        }
        return true;
    }

    public boolean fitsInSquare(int[][] grid, int row, int column) {
        int squareRow = (row / 3) * 3;
        int squareColumn = (column / 3) * 3;
        int num = grid[row][column];

        for (int i = squareRow; i < squareRow + 3; i++) {
            for (int j = squareColumn; j < squareColumn + 3; j++) {
                if (i == row && j == column) {
                    continue;
                } else if (grid[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
