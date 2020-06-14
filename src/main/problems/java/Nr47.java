package main.problems.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Nr47 {

    public static void main(String[] args) {
        Nr47 nr47 = new Nr47();
        List<List<Integer>> permutations = nr47.permuteUnique(new int[]{1, 1, 2});
        System.out.println(Arrays.deepToString(permutations.toArray()));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        return createPermutation(new ArrayList<>(), Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

    private List<List<Integer>> createPermutation(List<Integer> permutationSoFarm, List<Integer> missingNums) {
        Set<List<Integer>> permutationList = new HashSet<>();

        if (missingNums.isEmpty()) {
            permutationList.add(permutationSoFarm);
            return new ArrayList<>(permutationList);
        } else {
            for (Integer missingNum : missingNums) {
                List<Integer> copyPermutation = new ArrayList<>(permutationSoFarm);
                copyPermutation.add(missingNum);
                List<Integer> copyMissing = new ArrayList<>(missingNums);
                copyMissing.remove(missingNum);
                permutationList.addAll(createPermutation(copyPermutation, copyMissing));
            }
        }

        return new ArrayList<>(permutationList);
    }
}
