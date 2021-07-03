package main.problems.java;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Nr1631 {

    public static void main(String[] args) {
        Nr1631 nr1631 = new Nr1631();
        System.out.println(
                nr1631.minimumEffortPath(
                        new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}
                )
        );
    }

    public int minimumEffortPath(int[][] heights) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, 0});

        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        boolean[][] visited = new boolean[heights.length][heights[0].length];

        int maxHeightDiff = 0;
        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            visited[info[0]][info[1]] = true;
            int height = heights[info[0]][info[1]];
            int heightDiff = info[2];
            maxHeightDiff = Math.max(maxHeightDiff, heightDiff);

            if (info[0] == heights.length - 1 && info[1] == heights[0].length - 1) {
                return maxHeightDiff;
            }

            for (int[] dir : dirs) {
                int newRow = info[0] + dir[0], newCol = info[1] + dir[1];
                if (newRow < 0 || newRow > heights.length - 1 || newCol < 0 || newCol > heights[0].length - 1) continue;
                if (!visited[newRow][newCol]) {
                    pq.offer(new int[]{newRow, newCol, Math.abs(height - heights[newRow][newCol])});
                }
            }
        }
        throw new IllegalArgumentException();
    }
}
