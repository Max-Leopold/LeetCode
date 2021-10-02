package main.problems.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Nr139 {

	public static void main(String[] args) {
		Nr139 nr139 = new Nr139();

		List<String> wordDict = Arrays.asList("leet", "code");
		nr139.wordBreak("leetcode", wordDict);
		nr139.wordBreak("leetcodex", wordDict);
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> wordSet = new HashSet<>(wordDict);
		return wordBreak(s, wordSet);
	}

	public boolean wordBreak(String s, Set<String> wordSet) {
		boolean[] indexCanBeBroken = new boolean[s.length() + 1];
		indexCanBeBroken[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (indexCanBeBroken[j] && wordSet.contains(s.substring(j, i))) {
					indexCanBeBroken[i] = true;
				}
			}
		}

		return indexCanBeBroken[s.length()];
	}

}
