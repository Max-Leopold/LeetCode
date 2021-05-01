package main.other.stringpermutations;

// Task:
// Return a List<String> of all permutations of a String s in lexicographical order
// s only include uppercase english letters

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
                Arrays.toString(
                        solution.stringPermutations("AABC").toArray()
                )
        );
    }

    public List<String> stringPermutations(String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'A']++;
        }
        return createPermutations(
                counts,
                new char[s.length()],
                0,
                new ArrayList<>()
        );
    }

    private List<String> createPermutations(
            int[] counts,
            char[] result,
            int depth,
            List<String> resultStrings
    ) {
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) continue;
            result[depth] = (char) ('A' + i);
            if (depth == result.length - 1) {
                resultStrings.add(new String(result));
            } else {
                counts[i]--;
                createPermutations(
                        counts,
                        result,
                        depth + 1,
                        resultStrings
                );
                counts[i]++;
            }
        }
        return resultStrings;
    }
}
