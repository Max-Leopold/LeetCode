package main.problems.java;

import java.util.ArrayList;
import java.util.List;

public class Nr78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), powerSet);
        return powerSet;
    }

    private List<List<Integer>> subsets(
            int[] nums,
            int index,
            List<Integer> currentSet,
            List<List<Integer>> powerset
    ) {
        powerset.add(new ArrayList<>(currentSet));
        for (int i = index; i < nums.length; i++) {
            currentSet.add(nums[i]);
            subsets(nums, i + 1, currentSet, powerset);
            currentSet.remove(currentSet.size() - 1);
        }
        return powerset;
    }
}
