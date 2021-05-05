package main.problems.java;

public class Nr14 {
    public static void main(String[] args) {
        Nr14 nr14 = new Nr14();
        System.out.println(nr14.longestCommonPrefix(
                new String[]{"flower", "flow", "flight"}
        ));
    }

    public String longestCommonPrefix(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }
        if (strings.length == 1) {
            return strings[0];
        }

        String lastPrefix = strings[0];
        for (int i = 1; i < strings.length; i++) {
            if (lastPrefix.equals("")) {
                return "";
            }
            lastPrefix = getPrefix(lastPrefix, strings[i]);
        }

        return lastPrefix;
    }

    public String getPrefix(String first, String second) {
        for (int i = 0; i < first.length() && i < second.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return first.substring(0, i);
            }
            if (i == first.length() - 1) {
                return first;
            }
            if (i == second.length() - 1) {
                return second;
            }
        }

        return "";
    }
}
