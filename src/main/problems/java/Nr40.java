package main.problems.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Nr40 {
    public static void main(String[] args) {
        Nr40 nr40 = new Nr40();
        System.out.println(Arrays.toString(
                nr40.combinationSum2(
                        new int[]{1, 1, 2, 5, 6, 7, 10},
                        8
                ).toArray()
        ));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum2(
                candidates,
                target,
                0,
                new LinkedList<>(),
                0,
                new ArrayList<>()
        );
    }

    private List<List<Integer>> combinationSum2(
            int[] candidates,
            int target,
            int index,
            LinkedList<Integer> currentList,
            int currentSum,
            List<List<Integer>> result
    ) {
        if (currentSum > target || index > candidates.length) {
            return result;
        }
        if (currentSum == target) {
            result.add(new ArrayList<>(currentList));
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            currentList.add(candidates[i]);
            combinationSum2(
                    candidates,
                    target,
                    i + 1,
                    currentList,
                    currentSum + candidates[i],
                    result
            );
            currentList.removeLast();
        }
        return result;
    }
}
