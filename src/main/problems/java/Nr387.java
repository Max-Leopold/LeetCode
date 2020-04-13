package main.problems.java;

import java.util.HashMap;

public class Nr387 {

	public static void main(String[] args) {
		Nr387 nr387 = new Nr387();
		System.out.println(nr387.firstUniqChar("loveleetcode"));
	}

	public int firstUniqChar(String s) {
		HashMap<Character, Integer> counts = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (counts.containsKey(c)) {
				counts.put(c, counts.get(c) + 1);
			} else {
				counts.put(c, 1);
			}
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (counts.get(c) == 1) {
				return i;
			}
		}

		return -1;
	}
}
