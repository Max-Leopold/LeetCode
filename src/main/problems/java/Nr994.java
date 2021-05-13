package main.problems.java;

import java.util.LinkedList;
import java.util.Queue;

public class Nr994 {

    public static void main(String[] args) {
        Nr994 nr994 = new Nr994();
        System.out.println(
                nr994.orangesRotting(
                        new int[][]{
                                {2, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                                {1, 0, 1, 0, 1, 1, 1, 1, 0, 1},
                                {1, 0, 1, 0, 1, 0, 0, 1, 0, 1},
                                {1, 0, 1, 0, 1, 0, 0, 1, 0, 1},
                                {1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
                                {1, 0, 1, 0, 0, 0, 0, 1, 0, 1},
                                {1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
                                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
                        }
                )
        );
    }

    public int orangesRotting(int[][] grid) {
        Queue<Position> rotten = new LinkedList<>();
        int fresh = 0;
        int cycles = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    rotten.add(new Position(i, j));
                }
            }
        }

        while (!rotten.isEmpty()) {
            Queue<Position> newRotten = new LinkedList<>();
            while (!rotten.isEmpty()) {
                Position rottenPosition = rotten.poll();
                if (rottenPosition.x < grid.length - 1
                        && grid[rottenPosition.x + 1][rottenPosition.y] == 1) {
                    grid[rottenPosition.x + 1][rottenPosition.y] = 2;
                    newRotten.add(new Position(rottenPosition.x + 1, rottenPosition.y));
                    fresh--;
                }
                if (rottenPosition.x > 0
                        && grid[rottenPosition.x - 1][rottenPosition.y] == 1) {
                    grid[rottenPosition.x - 1][rottenPosition.y] = 2;
                    newRotten.add(new Position(rottenPosition.x - 1, rottenPosition.y));
                    fresh--;
                }
                if (rottenPosition.y < grid[0].length - 1
                        && grid[rottenPosition.x][rottenPosition.y + 1] == 1) {
                    grid[rottenPosition.x][rottenPosition.y + 1] = 2;
                    newRotten.add(new Position(rottenPosition.x, rottenPosition.y + 1));
                    fresh--;
                }
                if (rottenPosition.y > 0
                        && grid[rottenPosition.x][rottenPosition.y - 1] == 1) {
                    grid[rottenPosition.x][rottenPosition.y - 1] = 2;
                    newRotten.add(new Position(rottenPosition.x, rottenPosition.y - 1));
                    fresh--;
                }
            }
            rotten = newRotten;
            if (!newRotten.isEmpty()) {
                cycles++;
            }
        }

        return fresh == 0 ? cycles : -1;
    }

    class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
