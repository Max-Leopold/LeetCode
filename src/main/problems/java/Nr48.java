package main.problems.java;

/**
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Note:
 * <p>
 * You have to rotate the image in-place, which means you have to modify
 * the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 */

public class Nr48 {

  public void rotate(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = i; j < matrix[0].length; j++) {
        int temp = matrix[j][i];
        matrix[j][i] = matrix[i][j];
        matrix[i][j] = temp;
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length / 2; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][matrix.length - 1 - j];
        matrix[i][matrix.length - 1 - j] = temp;
      }
    }
  }
}
