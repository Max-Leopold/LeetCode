package main.problems.java;

import java.util.Arrays;

public class Nr1034 {

    private static final int COLOR = 1001;

    public static void main(String[] args) {
        Nr1034 nr1034 = new Nr1034();
        System.out.println(Arrays.deepToString(nr1034.colorBorder(
                new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}},
                1,
                1,
                2
        )));
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        if (grid[row][col] == color) {
            return grid;
        }
        dfs(grid, new boolean[grid.length][grid[0].length], row, col, grid[row][col]);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == COLOR) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }

    private void dfs(int[][] grid, boolean[][] visited, int row, int col, int colorToColor) {
        if (visited[row][col]) {
            return;
        } else if (isBorder(grid, row, col)) {
            grid[row][col] = COLOR;
        }
        visited[row][col] = true;
        if (row + 1 < grid.length && grid[row + 1][col] == colorToColor) {
            dfs(grid, visited, row + 1, col, colorToColor);
        }
        if (row - 1 >= 0 && grid[row - 1][col] == colorToColor) {
            dfs(grid, visited, row - 1, col, colorToColor);
        }
        if (col + 1 < grid[0].length && grid[row][col + 1] == colorToColor) {
            dfs(grid, visited, row, col + 1, colorToColor);
        }
        if (col - 1 >= 0 && grid[row][col - 1] == colorToColor) {
            dfs(grid, visited, row, col - 1, colorToColor);
        }
    }

    private boolean isBorder(int[][] grid, int row, int col) {
        return row == 0 ||
                row == grid.length - 1 ||
                col == 0 ||
                col == grid[0].length - 1 ||
                (grid[row + 1][col] != grid[row][col] && grid[row + 1][col] != COLOR) ||
                (grid[row - 1][col] != grid[row][col] && grid[row - 1][col] != COLOR) ||
                (grid[row][col + 1] != grid[row][col] && grid[row][col + 1] != COLOR) ||
                (grid[row][col - 1] != grid[row][col] && grid[row][col - 1] != COLOR);
    }
}
