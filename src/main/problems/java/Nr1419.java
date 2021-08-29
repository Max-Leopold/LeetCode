package main.problems.java;

public class Nr1419 {

    private static final char[] charIndex = new char[]{'c', 'r', 'o', 'a', 'k'};

    public static void main(String[] args) {
        Nr1419 nr1419 = new Nr1419();
        System.out.println(nr1419.minNumberOfFrogs("crcoakroak"));
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] counter = new int[5];
        int currentSum = 0;
        int max = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char currentChar = croakOfFrogs.charAt(i);
            int charIndex = "croak".indexOf(currentChar);
            counter[charIndex]++;
            currentSum++;
            if (charIndex > 0) {
                if (--counter[charIndex - 1] < 0) {
                    return -1;
                }
                currentSum--;
            }
            if (charIndex == counter.length - 1) {
                counter[counter.length - 1]--;
                currentSum--;
            }
            max = Math.max(max, currentSum);
        }
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) return -1;
        }
        return max;
    }
}
