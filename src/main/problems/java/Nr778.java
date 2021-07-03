package main.problems.java;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Nr778 {

    // Pq holds information. Coordinates + water height

    public static void main(String[] args) {
        Nr778 nr778 = new Nr778();
        System.out.println(
                nr778.swimInWater(
                        new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}}
                )
        );
    }

    public int swimInWater(int[][] grid) {
        int t = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] directions = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        pq.offer(new int[]{0, 0, grid[0][0]});
        visited[0][0] = true;
        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            t = Math.max(t, info[2]);
            for (int i = 0; i < directions.length; i++) {
                int[] direction = directions[i];

                int newX = info[0] + direction[0], newY = info[1] + direction[1];
                if (newX < 0 || newX > grid[0].length - 1 || newY < 0 || newY > grid.length - 1) continue;
                if (!visited[newX][newY]) {
                    visited[newX][newY] = true;
                    pq.offer(new int[]{newX, newY, grid[newX][newY]});
                    if (newX == grid.length - 1 && newY == grid[0].length - 1) {
                        return Math.max(t, grid[newX][newY]);
                    }
                }
            }
        }
        throw new IllegalArgumentException();
    }
}
