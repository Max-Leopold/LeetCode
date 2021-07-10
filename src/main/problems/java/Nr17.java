package main.problems.java;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Nr17 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }

        HashMap<Character, char[]> phoneMapping = new HashMap<>();
        phoneMapping.put('2', new char[]{'a', 'b', 'c'});
        phoneMapping.put('3', new char[]{'d', 'e', 'f'});
        phoneMapping.put('4', new char[]{'g', 'h', 'i'});
        phoneMapping.put('5', new char[]{'j', 'k', 'l'});
        phoneMapping.put('6', new char[]{'m', 'n', 'o'});
        phoneMapping.put('7', new char[]{'p', 'q', 'r', 's'});
        phoneMapping.put('8', new char[]{'t', 'u', 'v'});
        phoneMapping.put('9', new char[]{'w', 'x', 'y', 'z'});

        return letterCombinations(digits, phoneMapping, 0, new StringBuilder(), new LinkedList<>());
    }

    private List<String> letterCombinations(
            String digits,
            HashMap<Character, char[]> phoneMapping,
            int index,
            StringBuilder stringSoFar,
            List<String> combinations
    ) {
        if (index == digits.length()) {
            combinations.add(stringSoFar.toString());
            return combinations;
        }

        char[] chars = phoneMapping.get(digits.charAt(index));
        for (char c : chars) {
            letterCombinations(
                    digits,
                    phoneMapping,
                    index + 1,
                    stringSoFar.append(c),
                    combinations
            );
            stringSoFar.setLength(index);
        }
        return combinations;
    }
}
