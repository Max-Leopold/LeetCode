package main.problems.java;

public class Nr1781 {
    public int beautySum(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] charCounter = new int[26];
            for (int j = i; j < s.length(); j++) {
                charCounter[s.charAt(j) - 'a']++;

                sum += beauty(charCounter);
            }
        }
        return sum;
    }

    private int beauty(int[] charCounter) {
        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < charCounter.length; i++) {
            if (charCounter[i] != 0) {
                min = Math.min(charCounter[i], min);
                max = Math.max(charCounter[i], max);
            }
        }
        return max - min;
    }
}
