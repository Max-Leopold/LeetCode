package main.problems.java;

public class Nr74 {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		int row = findRow(matrix, target);
		if (row == -1) {
			return false;
		}

		return findColumn(matrix, target, row);
	}

	private boolean findColumn(int[][] matrix, int target, int row) {
		for (int i = 0; i < matrix[row].length; i++) {
			if (target == matrix[row][i]) {
				return true;
			}
		}

		return false;
	}

	public int findRow(int[][] matrix, int target) {
		for (int i = 0; i < matrix.length - 1; i++) {
			if (target < matrix[i + 1][0] && target >= matrix[i][0]) {
				return i;
			}
		}

		if (target <= matrix[matrix.length - 1][matrix[matrix.length - 1].length - 1]) {
			return matrix.length - 1;
		}

		return -1;
	}
}
