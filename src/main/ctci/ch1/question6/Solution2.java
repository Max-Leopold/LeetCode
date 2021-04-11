package main.ctci.ch1.question6;

// Calculate compressed String length upfront
// Initialize StringBuilder with right length

public class Solution2 {

    static String stringCompression(String toCompress) {
        if (toCompress == null || toCompress.length() < 2) {
            return toCompress;
        }

        int compressedLength = compressedLength(toCompress);
        if (compressedLength > toCompress.length()) {
            return toCompress;
        }

        StringBuilder sb = new StringBuilder(compressedLength);
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

        return sb.toString();
    }

    private static int compressedLength(String toCompress) {
        int compressedLength = 0;
        int charCount = 1;
        char currentlyCompressing = toCompress.charAt(0);
        for (int i = 0; i < toCompress.length(); i++) {
            if (toCompress.charAt(i) != currentlyCompressing) {
                compressedLength += 1 + String.valueOf(charCount).length();

                charCount = 1;
                currentlyCompressing = toCompress.charAt(i);
            } else {
                charCount++;
            }
        }
        compressedLength += 1 + String.valueOf(charCount).length();

        return compressedLength;
    }
}
