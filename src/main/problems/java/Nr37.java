package main.problems.java;

public class Nr37 {

    public boolean solveSudoku(char[][] grid, int row, int column) {
        for (int i = 0; i < grid[row].length; i++) {
            boolean solved;
            if (grid[row][i] == '.') {
                for (int j = 49; j < 49 + 9; j++) {
                    grid[row][i] = (char) j;
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
                grid[row][i] = '.';
                return false;
            }
        }
        if (row == grid.length - 1) {
            return true;
        } else {
            return solveSudoku(grid, row + 1, 0);
        }
    }

    public boolean fitsInRow(char[][] grid, int row, int column) {
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

    public boolean fitsInColumn(char[][] grid, int row, int column) {
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

    public boolean fitsInSquare(char[][] grid, int row, int column) {
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
