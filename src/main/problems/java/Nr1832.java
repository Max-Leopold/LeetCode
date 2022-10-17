package main.problems.java;

public class Nr1832 {

    public boolean checkIfPangram(String sentence) {
        int seen = 0;
        for (int i = 0; i < sentence.length(); i++) {
            seen |= (1 << sentence.charAt(i) - 'a');
        }
        return seen == (1 << 26) - 1;
    }

    public boolean checkIfPangram2(String sentence) {
        boolean[] seen = new boolean[26];
        for (int i = 0; i < sentence.length(); i++) {
            seen[sentence.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < seen.length; i++) {
            if (!seen[i]) return false;
        }

        return true;
    }

    public boolean checkIfPangram3(String sentence) {
        boolean[] seen = new boolean[26];
        int totalSeen = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (!seen[sentence.charAt(i) - 'a']) {
                seen[sentence.charAt(i) - 'a'] = true;
                totalSeen++;
            }

            if (totalSeen == 26) return true;
        }

        return false;
    }
}
