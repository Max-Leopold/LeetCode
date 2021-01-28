package main.other.highestprofit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// See https://leetcode.com/discuss/interview-question/868302/Amazon-or-OA2-2020-or-Find-The-Highest-Profit
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Long> inv = new ArrayList<>();
        inv.add(5L);
        inv.add(3L);

        System.out.println(solution.highestProfit(2, inv, 6));
    }

    long highestProfit(int numSuppliers, List<Long> inventory, long order) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(inventory.size(), Collections.reverseOrder());
        maxHeap.addAll(inventory);

        long profit = 0;
        long ordered = 0;
        while (ordered < order) {
            if (maxHeap.isEmpty()) {
                break;
            }

            long newProfit = maxHeap.remove();
            profit += newProfit;

            long newStock = newProfit - 1;
            if (newStock > 0) {
                maxHeap.add(newStock);
            }

            ordered++;
        }

        return profit;
    }
}
