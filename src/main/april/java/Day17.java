package main.april.java;

public class Day17 {

	int islandNumber = 0;

	public static void main(String[] args) {
		Day17 day17 = new Day17();
		char[][] chars = new char[][]{
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'}};
		System.out.println(day17.numIslands(chars));
	}

	public int numIslands(char[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					islandNumber += 1;
					cleanIsland(grid, i, j);
				}
			}
		}

		return islandNumber;
	}

	public void cleanIsland(char[][] grid, int x, int y) {
		grid[x][y] = '0';
		if (x > 0 && grid[x - 1][y] == '1') {
			cleanIsland(grid, x - 1, y);
		}
		if (y > 0 && grid[x][y - 1] == '1') {
			cleanIsland(grid, x, y - 1);
		}
		if (x < grid.length - 1 && grid[x + 1][y] == '1') {
			cleanIsland(grid, x + 1, y);
		}
		if (y < grid[x].length - 1 && grid[x][y + 1] == '1') {
			cleanIsland(grid, x, y + 1);
		}
	}
}
