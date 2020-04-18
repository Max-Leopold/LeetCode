package main.april.java;

public class Day18 {

	public static void main(String[] args) {
		Day18 day18 = new Day18();
		System.out.println(day18.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
	}

	public int minPathSum(int[][] grid) {
		int[][] minCosts = new int[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				int top = i > 0 ? minCosts[i - 1][j] : Integer.MAX_VALUE;
				int left = j > 0 ? minCosts[i][j - 1] : Integer.MAX_VALUE;


				if (i == 0 && j == 0) {
					minCosts[i][j] = grid[i][j];
				} else {
					minCosts[i][j] = Math.min(top, left) + grid[i][j];
				}
			}
		}

		return minCosts[grid.length - 1][grid[0].length - 1];
	}
}
