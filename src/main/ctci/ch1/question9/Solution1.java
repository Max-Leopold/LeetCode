package main.ctci.ch1.question9;

public class Solution1 {

    static boolean alreadyCalledIsSubstring;

    static boolean stringRotation(String first, String second) throws IllegalAccessException {
        if (first != null && second != null && first.length() == second.length()) {
            return isSubstring(first, second + second);
        }

        return false;
    }

    private static boolean isSubstring(String first, String second) throws IllegalAccessException {
        if (alreadyCalledIsSubstring) {
            throw new IllegalAccessException("You can only call isSubstring once");
        }
        alreadyCalledIsSubstring = true;
        return second.contains(first);
    }
}
