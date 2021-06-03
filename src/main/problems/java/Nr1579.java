package main.problems.java;

public class Nr1579 {
    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c != '?') {
                continue;
            } else {
                char front = ' ';
                char back = ' ';
                char newChar = 'a';
                if (i != 0) {
                    back = chars[i - 1];
                }
                if (i < s.length() - 1) {
                    front = chars[i + 1];
                }
                while (newChar == front || newChar == back) {
                    newChar += 1;
                }
                chars[i] = newChar;
            }
        }
        return new String(chars);
    }
}
