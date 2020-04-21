package main.april.java;

import main.util.java.BinaryMatrix;
import main.util.java.BinaryMatrixImpl;

import java.util.List;

public class Day21 {

	public static void main(String[] args) {
		BinaryMatrix binaryMatrix = new BinaryMatrixImpl(new int[][]{{0, 0}, {1, 1}, {1, 1}});
		Day21 day21 = new Day21();
		System.out.println(day21.leftMostColumnWithOne(binaryMatrix));
	}

	public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		List<Integer> dimensions = binaryMatrix.dimensions();
		int columns = dimensions.get(0);
		int rows = dimensions.get(1);

		int firstOneColum = -1;

		for (int i = 0; i < columns; i++) {
			if (binaryMatrix.get(i, rows - 1) == 1) {
				while (binaryMatrix.get(i, rows - 1) == 1) {
					rows -= 1;
					if (rows == 0) {
						return 0;
					}
				}
				firstOneColum = rows;
			}
		}

		return firstOneColum;
	}
}
