package main.ctci.ch1.question5;

// Questions
// Can the Strings include Whitespaces? (Assumption: Yes)
// Does capitalization matter? (Assumption: Yes)


public class Solution1 {

    static boolean oneAway(String first, String second) {
        // First should always be the longer String -> Makes other steps easier
        if (first.length() < second.length()) {
            String tmp = first;
            first = second;
            second = tmp;
        }

        if (first.length() - second.length() > 1) {
            return false;
        }

        // Must be edit
        if (first.length() == second.length()) {
            boolean foundDelete = false;

            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    if (foundDelete) {
                        return false;
                    } else {
                        foundDelete = true;
                    }
                }
            }

            return true;
        }
        // Must be delete or insert
        else {
            boolean foundDiff = false;
            int secondPointer = 0;

            for (int i = 0; i < first.length() - 1; i++) {
                if (first.charAt(i) != second.charAt(secondPointer)) {
                    if (foundDiff) {
                        return false;
                    } else {
                        foundDiff = true;
                        i++;
                    }
                }
                secondPointer++;
            }

            // Check last character
            if (foundDiff && first.charAt(first.length() - 1) != second.charAt(second.length() - 1)) {
                return false;
            }

            return true;
        }
    }
}
