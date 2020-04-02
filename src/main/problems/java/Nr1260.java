package main.problems.java;

import java.util.ArrayList;
import java.util.List;

public class Nr1260 {

  public List<List<Integer>> shiftGrid(int[][] grid, int k) {
    for (int i = 0; i < k; i++) {
      shiftColumns(grid);
    }

    List<List<Integer>> list = new ArrayList<>();
    for (int i = 0; i < grid.length; i++) {
      List<Integer> arrList = new ArrayList<>();

      for (int j = 0; j < grid[i].length; j++) {
        arrList.add(grid[i][j]);
      }
      list.add(arrList);
    }

    return list;
  }

  public int[][] shiftColumns(int[][] grid) {
    int[] temp = createLastColumnArray(grid);

    for (int i = 0; i < grid.length; i++) {
      for (int j = grid[i].length - 1; j > 0; j--) {
        grid[i][j] = grid[i][j - 1];
      }
    }

    for (int i = 0; i < grid.length; i++) {
      grid[i][0] = temp[i];
    }

    return grid;
  }

  public int[] createLastColumnArray(int[][] grid) {
    int temp[] = new int[grid.length];

    for (int i = 0; i < grid.length; i++) {
      temp[(i + 1) % grid.length] = grid[i][grid[i].length - 1];
    }

    return temp;
  }
}
