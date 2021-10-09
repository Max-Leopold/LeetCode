package main.problems.java;

import java.util.LinkedList;
import java.util.List;

public class Nr1417 {
	public String reformat(String s) {
		List<Character> digits = new LinkedList();
		List<Character> characters = new LinkedList();

		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				digits.add(c);
			} else {
				characters.add(c);
			}
		}

		if (Math.abs(digits.size() - characters.size()) > 1) {
			return "";
		}

		if (digits.size() > characters.size()) {
			return buildString(digits, characters);
		} else {
			return buildString(characters, digits);
		}
	}

	private String buildString(List<Character> firstList, List<Character> secondList) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < firstList.size(); i++) {
			sb.append(firstList.get(i));
			if (i < secondList.size()) {
				sb.append(secondList.get(i));
			}
		}

		return sb.toString();
	}
}
