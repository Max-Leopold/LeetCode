package main.ctci.ch1.question6;

public class Solution1 {

    static String stringCompression(String toCompress) {
        if (toCompress == null || toCompress.length() < 2) {
            return toCompress;
        }

        StringBuilder sb = new StringBuilder();
        int charCount = 1;
        char charToCompress = toCompress.charAt(0);

        for (int i = 1; i < toCompress.length(); i++) {
            if (toCompress.charAt(i) != charToCompress) {
                // Compress
                sb.append(charToCompress);
                sb.append(charCount);


                charCount = 1;
                charToCompress = toCompress.charAt(i);
            } else {
                // Count
                charCount++;
            }
        }

        // Compress last
        sb.append(charToCompress);
        sb.append(charCount);

        return sb.length() < toCompress.length() ? sb.toString() : toCompress;
    }
}
