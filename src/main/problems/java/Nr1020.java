package main.problems.java;

public class Nr1020 {
    public static void main(String[] args) {
        Nr1020 nr1020 = new Nr1020();
        System.out.println(
                nr1020.numEnclaves(
                        new int[][]{
                                {0, 1, 0},
                                {1, 0, 1},
                                {1, 0, 1},
                                {0, 1, 0},
                                {1, 0, 1}
                        }
                )
        );
    }

    public int numEnclaves(int[][] grid) {
        if (grid == null || grid.length == 1 || grid[0].length == 1) {
            return 0;
        }

        walkXAxis(grid, 0);
        walkXAxis(grid, grid.length - 1);
        walkYAxis(grid, 0);
        walkYAxis(grid, grid[0].length - 1);

        int counter = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                if (grid[i][j] == 1) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private int walkXAxis(int[][] grid, int y) {
        int counter = 0;
        for (int x = 0; x < grid[0].length; x++) {
            counter += walkIsland(grid, x, y);
        }
        return counter;
    }

    private int walkYAxis(int[][] grid, int x) {
        int counter = 0;
        for (int y = 0; y < grid.length; y++) {
            counter += walkIsland(grid, x, y);
        }
        return counter;
    }

    private int walkIsland(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid[0].length) {
            return 0;
        }
        if (y < 0 || y >= grid.length) {
            return 0;
        }

        if (grid[y][x] == 1) {
            grid[y][x] = 0;
            int counter = 1;
            counter += walkIsland(grid, x + 1, y);
            counter += walkIsland(grid, x - 1, y);
            counter += walkIsland(grid, x, y + 1);
            counter += walkIsland(grid, x, y - 1);
            return counter;
        }
        return 0;
    }
}
