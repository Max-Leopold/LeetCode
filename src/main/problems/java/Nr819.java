package main.problems.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Nr819 {

    public static void main(String[] args) {
        Nr819 nr819 = new Nr819();
        System.out.println(nr819.mostCommonWord(
                "Bob hit a ball, the hit BALL flew far after it was hit.",
                new String[]{"hit"}
        ));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> wordCounts = new HashMap<>();
        List<String> bannedList = Arrays.asList(banned);

        String maxWord = "";
        int maxOcc = 0;

        for (String word : paragraph.split("[!?',;.\\s]")) {
            word = word.trim().toLowerCase();
            if (word.length() == 0) continue;

            if (!bannedList.contains(word)) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                if (wordCounts.get(word) > maxOcc) {
                    maxWord = word;
                    maxOcc = wordCounts.get(word);
                }
            }
        }

        return maxWord;
    }
}
