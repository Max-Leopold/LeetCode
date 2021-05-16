package main.problems.java;

public class Nr58 {
    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        String[] words = s.split(" ");
        if (words.length > 0) {
            return words[words.length - 1].length();
        }
        return 0;
    }
}
