package main.problems.java;

public class Nr1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder word1Sb = new StringBuilder();
        StringBuilder word2Sb = new StringBuilder();
        int max = Math.max(word1.length, word2.length);
        for (int i = 0; i < max; i++) {
            if (max < word1.length) {
                word1Sb.append(word1[i]);
            }
            if (max < word2.length) {
                word2Sb.append(word2[i]);
            }
        }
        return word1Sb.toString().equals(word2Sb.toString());
    }
}
