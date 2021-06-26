package main.problems.java;

public class Nr1309 {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i + 2 < s.length()) {
                if (s.charAt(i + 2) == '#') {
                    char c = (char) ((char) Integer.parseInt(s.substring(i, i + 2)) + 'a' - 1);
                    sb.append(c);
                    i = i + 2;
                    continue;
                }
            }
            char c = (char) ('a' + Integer.parseInt(s.substring(i, i + 1)) - 1);
            sb.append(c);
        }
        return sb.toString();
    }
}
