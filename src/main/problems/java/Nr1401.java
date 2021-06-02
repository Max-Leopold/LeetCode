package main.problems.java;

public class Nr1401 {
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {

        // Is inside
        if (x_center >= x1 && x_center <= x2 && y_center >= y1 && y_center <= y2) {
            return true;
        }

        int dx = Math.max(x1 - x_center, Math.max(0, x_center - x2));
        int dy = Math.max(y1 - y_center, Math.max(0, y_center - y2));
        return Math.sqrt(dx * dx + dy * dy) <= radius;
    }
}
