package main.problems.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Nr587 {
    public static void main(String[] args) {
        Nr587 nr587 = new Nr587();
        System.out.println(Arrays.deepToString(nr587.outerTrees(
                new int[][]{{1, 1}, {2, 2}, {2, 0}, {2, 4}, {3, 3}, {4, 2}}
        )));
    }

    public int[][] outerTrees(int[][] trees) {
        int[] pointOnHull = trees[0];
        for (int i = 1; i < trees.length; i++) {
            if (trees[i][0] < pointOnHull[0]) {
                pointOnHull = trees[i];
            }
        }
        List<int[]> res = new ArrayList<>();
        List<int[]> pointsOnThisLine = new LinkedList<>();
        int i = 0;
        do {
            res.addAll(pointsOnThisLine);
            pointsOnThisLine = new LinkedList<>();
            res.add(pointOnHull);
            i = res.size() - 1;
            int[] endpoint = res.get(0);
            pointsOnThisLine.add(endpoint);
            for (int j = 0; j < trees.length; j++) {
                double isLeftValue = isLeft(
                        res.get(i)[0],
                        res.get(i)[1],
                        endpoint[0],
                        endpoint[1],
                        trees[j][0],
                        trees[j][1]
                );
                if (endpoint == pointOnHull || isLeftValue > 0) {
                    endpoint = trees[j];
                    pointsOnThisLine = new LinkedList<>();
                    pointsOnThisLine.add(trees[j]);
                } else if (isLeftValue == 0 && !res.contains(trees[j])) {
                    pointsOnThisLine.add(trees[j]);
                }
            }
            int[] furthestAway = pointsOnThisLine.get(0);
            for (int[] tree : pointsOnThisLine) {
                if (getDistance(res.get(i), furthestAway) < getDistance(res.get(i), tree)) {
                    furthestAway = tree;
                }
            }
            pointsOnThisLine.remove(furthestAway);
            pointOnHull = furthestAway;
        } while (pointOnHull != res.get(0));
        res.addAll(pointsOnThisLine);
        int[][] fence = new int[res.size()][2];
        for (int j = 0; j < res.size(); j++) {
            fence[j] = res.get(j);
        }
        return fence;
    }

    public double getDistance(int[] p1, int[] p2) {
        return Math.sqrt(Math.pow(p2[1] - p1[1], 2) + Math.pow(p2[0] - p1[0], 2));
    }

    public double isLeft(int x1, int y1, int x2, int y2, int x3, int y3) {
        return ((x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1));
    }
}
