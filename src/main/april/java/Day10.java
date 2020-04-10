package main.april.java;

import java.util.Stack;

public class Day10 {
	class StackObject {
		private final int val;
		private final int min;

		public StackObject(int val, int min) {
			this.val = val;
			this.min = min;
		}

		public int getVal() {
			return val;
		}

		public int getMin() {
			return min;
		}
	}

	class MinStack {
		private final Stack<StackObject> stack = new Stack<>();

		/**
		 * initialize your data structure here.
		 */
		public MinStack() {

		}

		public void push(int x) {
			int min = x;
			if (!stack.isEmpty()) {
				min = Math.min(min, stack.peek().getMin());
			}
			stack.push(new StackObject(x, min));
		}

		public void pop() {
			stack.pop();
		}

		public int top() {
			if (stack.isEmpty()) {
				return -1;
			}
			return stack.peek().getVal();
		}

		public int getMin() {
			if (stack.isEmpty()) {
				return -1;
			}
			return stack.peek().getMin();
		}
	}
}
