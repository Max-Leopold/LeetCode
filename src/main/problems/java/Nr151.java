package main.problems.java;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Nr151 {
	public String reverseWords(String s) {
		s = s.trim();
		List<String> words = splitWords(s);
		Collections.reverse(words);
		return String.join(" ", words);
	}

	private List<String> splitWords(String s) {
		List<String> words = new LinkedList<>();
		int start = 0;
		int end = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				if (start != end) {
					words.add(s.substring(start, end + 1));
				}
				start = i + 1;
				end = i + 1;
			} else {
				end++;
			}
		}
		if (start != end) {
			words.add(s.substring(start));
		}
		return words;
	}
}
