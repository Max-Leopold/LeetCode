package main.problems.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Nr39 {
    public static void main(String[] args) {
        Nr39 nr39 = new Nr39();
        nr39.combinationSum(new int[]{2, 3, 6, 7}, 7);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSum(
                candidates,
                target,
                0,
                new LinkedList<>(),
                0,
                new ArrayList<>()
        );
    }

    private List<List<Integer>> combinationSum(
            int[] candidates,
            int target,
            int index,
            LinkedList<Integer> currentList,
            int currentSum,
            List<List<Integer>> result
    ) {
        if (currentSum > target || index >= candidates.length) {
            return result;
        }
        if (currentSum == target) {
            result.add(new ArrayList<>(currentList));
        }
        for (int i = index; i < candidates.length; i++) {
            currentList.add(candidates[i]);
            combinationSum(
                    candidates,
                    target,
                    i,
                    currentList,
                    currentSum + candidates[i],
                    result
            );
            currentList.removeLast();
        }
        return result;
    }
}
