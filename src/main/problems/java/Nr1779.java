package main.problems.java;

public class Nr1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minDis = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x) {
                int distance = Math.abs(y - points[i][1]);
                if (distance < minDis) {
                    minDis = distance;
                    minIndex = i;
                }
            } else if (points[i][1] == y) {
                int distance = Math.abs(x - points[i][0]);
                if (distance < minDis) {
                    minDis = distance;
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }
}
