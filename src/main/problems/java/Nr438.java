package main.problems.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nr438 {

    public static void main(String[] args) {
        Nr438 nr438 = new Nr438();
        System.out.println(Arrays.toString(nr438.findAnagrams("cbaebabacd", "abc").toArray()));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> index = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return index;
        }

        int[] charHash = new int[256];
        for (char c : p.toCharArray()) {
            charHash[c]++;
        }

        int right = 0;
        int left = 0;
        int counter = p.length();
        while (right < s.length()) {
            if (charHash[s.charAt(right)] > 0) {
                charHash[s.charAt(right)]--;
                counter--;
                right++;
            } else {
                charHash[s.charAt(left)]++;
                counter++;
                left++;
            }

            if (counter == 0) {
                index.add(left);
            }
        }

        return index;
    }
}
