package main.problems.java;

import java.util.HashMap;

public class Nr3 {
	public static void main(String[] args) {
		Nr3 nr3 = new Nr3();
		System.out.println(nr3.lengthOfLongestSubstring("bbbbb"));
	}

	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> charIndex = new HashMap<>();
		int slowPointer = 0;
		int maxLength = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int lastSeen = charIndex.getOrDefault(c, -1);

			if (lastSeen >= slowPointer) {
				slowPointer = lastSeen + 1;
			}
			maxLength = Math.max(maxLength, i - slowPointer + 1);
			charIndex.put(c, i);
		}

		return maxLength;
	}
}
