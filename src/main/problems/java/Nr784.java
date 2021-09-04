package main.problems.java;

import java.util.ArrayList;
import java.util.List;

public class Nr784 {
    public List<String> letterCasePermutation(String s) {
        List<String> permutations = new ArrayList<>();
        generatePermutations(s, new StringBuilder(), 0, permutations);
        return permutations;
    }

    private void generatePermutations(String s, StringBuilder sb, int index, List<String> permutations) {
        if (s.length() == index) {
            permutations.add(sb.toString());
            return;
        }
        char c = s.charAt(index);
        if (Character.isLetter(c)) {
            sb.append(Character.toLowerCase(c));
            generatePermutations(s, sb, index + 1, permutations);
            sb.setLength(index);
            sb.append(Character.toUpperCase(c));
            generatePermutations(s, sb, index + 1, permutations);
            sb.setLength(index);
        } else {
            sb.append(c);
            generatePermutations(s, sb, index + 1, permutations);
            sb.setLength(index);
        }
    }
}
