package main.problems.java;

import java.util.Stack;

public class Nr20 {

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			}
			if (stack.isEmpty()) {
				return false;
			} else {
				if (c == '}') {
					if (stack.peek() == '{') stack.pop();
					else return false;
				} else if (c == ')') {
					if (stack.peek() == '(') stack.pop();
					else return false;
				} else if (c == ']') {
					if (stack.peek() == '[') stack.pop();
					else return false;
				}
			}
		}

		return stack.isEmpty();
	}
}
