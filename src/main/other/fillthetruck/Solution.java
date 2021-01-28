package main.other.fillthetruck;

import java.util.Comparator;
import java.util.PriorityQueue;

// See https://leetcode.com/discuss/interview-question/948919/Amazon-or-OA2-or-Fill-The-Truck
public class Solution {
    public int fillTheTruck(int num, int[] boxes, int unitSize, int[] unitsPerBox, long truckSize) {
        PriorityQueue<ProductBox> heap = new PriorityQueue<ProductBox>(unitSize, new ProductBoxComparer());

        for (int i = 0; i < unitSize; i++) {
            ProductBox pb = new ProductBox(i, unitsPerBox[i]);
            heap.add(pb);
        }

        long sum = 0;
        int alreadyLoaded = 0;
        while (alreadyLoaded < truckSize) {
            if (heap.isEmpty()) {
                break;
            }
            ProductBox pb = heap.remove();
            System.out.println(pb);
            long howManyBoxes = boxes[pb.getBoxIndex()];
            while (howManyBoxes > 0 && alreadyLoaded < truckSize) {
                howManyBoxes--;
                alreadyLoaded++;
                sum += pb.getUnits();
            }
        }
        return (int) sum;
    }

    private class ProductBox {
        private int boxIndex;
        private int units;

        public ProductBox(int boxIndex, int units) {
            this.boxIndex = boxIndex;
            this.units = units;
        }

        public int getBoxIndex() {
            return boxIndex;
        }

        public int getUnits() {
            return units;
        }

        @Override
        public String toString() {
            return "ProductBox{" +
                    "boxIndex=" + boxIndex +
                    ", units=" + units +
                    '}';
        }
    }

    private class ProductBoxComparer implements Comparator<ProductBox> {
        @Override
        public int compare(ProductBox x, ProductBox y) {
            if (x.getUnits() < y.getUnits()) {
                return 1;
            } else if (x.getUnits() > y.getUnits()) {
                return -1;
            }

            return 0;
        }
    }
}
