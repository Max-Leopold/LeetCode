package main.util.java;

import java.util.ArrayList;
import java.util.List;

public class BinaryMatrixImpl implements BinaryMatrix {

	private final int[][] matrix;
	private ArrayList<Integer> dimensions = new ArrayList<>();

	public BinaryMatrixImpl(int[][] matrix) {
		this.matrix = matrix;

		dimensions.add(matrix.length);
		dimensions.add(matrix[0].length);
	}

	@Override
	public int get(int x, int y) {
		return matrix[x][y];
	}

	@Override
	public List<Integer> dimensions() {
		return dimensions;
	}
}
