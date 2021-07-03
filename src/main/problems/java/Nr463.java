package main.problems.java;

public class Nr463 {

    public static void main(String[] args) {
        Nr463 nr463 = new Nr463();
        System.out.println(nr463.islandPerimeter(
                new int[][]{
                        {0, 1, 0, 0},
                        {1, 1, 1, 0},
                        {0, 1, 0, 0},
                        {1, 1, 0, 0}
                }
        ));
    }

    public int islandPerimeter(int[][] grid) {
        boolean foundIsland = false;
        int x = 0;
        int y = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    x = j;
                    y = i;
                    foundIsland = true;
                    break;
                }
            }
            if (foundIsland) {
                break;
            }
        }

        return dfs(grid, x, y);
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x > grid[0].length - 1 || y > grid.length - 1 || grid[y][x] != 1) {
            return 0;
        }

        int sidesFacingWater = sidesFacingWater(grid, x, y);
        grid[y][x] = -1;
        return sidesFacingWater
                + dfs(grid, x + 1, y)
                + dfs(grid, x - 1, y)
                + dfs(grid, x, y + 1)
                + dfs(grid, x, y - 1);
    }

    private int sidesFacingWater(int[][] grid, int x, int y) {
        int sidesFacingWater = 0;
        if (x == grid[0].length - 1 || grid[y][x + 1] == 0) {
            sidesFacingWater++;
        }
        if (x == 0 || grid[y][x - 1] == 0) {
            sidesFacingWater++;
        }

        if (y == grid.length - 1 || grid[y + 1][x] == 0) {
            sidesFacingWater++;
        }
        if (y == 0 || grid[y - 1][x] == 0) {
            sidesFacingWater++;
        }

        return sidesFacingWater;
    }

}
