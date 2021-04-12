package main.ctci.ch1.question9;

public class Solution1 {

    static boolean alreadyCalledIsSubstring;

    static boolean stringRotation(String first, String second) throws IllegalAccessException {
        String secondDoubled = second + second;

        return isSubstring(first, secondDoubled);
    }

    private static boolean isSubstring(String first, String second) throws IllegalAccessException {
        if (alreadyCalledIsSubstring) {
            throw new IllegalAccessException("You can only call isSubstring once");
        }
        alreadyCalledIsSubstring = true;
        return second.contains(first);
    }
}
