package main.problems.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*

nums: [1,2,3]
-> [1] [2,3]
    -> [1,2] [3]
        -> [1,2,3]
    -> [1,3] [2]
        -> [1,3,2]
---
 */
public class Nr46 {

    public List<List<Integer>> permute(int[] nums) {
        return createPermutation(new ArrayList<>(), Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

    private List<List<Integer>> createPermutation(List<Integer> permutationSoFarm, List<Integer> missingNums) {
        List<List<Integer>> permutationList = new ArrayList<>();

        if (missingNums.isEmpty()) {
            permutationList.add(permutationSoFarm);
            return permutationList;
        } else {
            for (Integer missingNum : missingNums) {
                List<Integer> copyPermutation = new ArrayList<>(permutationSoFarm);
                copyPermutation.add(missingNum);
                List<Integer> copyMissing = new ArrayList<>(missingNums);
                copyMissing.remove(missingNum);
                permutationList.addAll(createPermutation(copyPermutation, copyMissing));
            }
        }

        return permutationList;
    }
}
