package main.problems.java;

public class Nr1582 {
	public int numSpecial(int[][] mat) {
		int specialPositions = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == 1 && isSpecialPosition(mat, i, j)) {
					specialPositions++;
					break;
				}
			}
		}
		return specialPositions;
	}

	private boolean isSpecialPosition(int[][] mat, int row, int column) {
		return countOnesInRow(mat, row) == 1 && countOnesInColumn(mat, column) == 1;
	}

	private int countOnesInRow(int[][] mat, int row) {
		int onesInColumn = 0;
		for (int column = 0; column < mat[row].length; column++) {
			if (mat[row][column] == 1) {
				onesInColumn++;
			}
		}
		return onesInColumn;
	}

	private int countOnesInColumn(int[][] mat, int column) {
		int onesInRow = 0;
		for (int row = 0; row < mat.length; row++) {
			if (mat[row][column] == 1) {
				onesInRow++;
			}
		}
		return onesInRow;
	}
}
