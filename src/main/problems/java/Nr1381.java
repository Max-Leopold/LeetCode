package main.problems.java;

public class Nr1381 {

    class CustomStack {
        final int[] stack;
        int currentElement = -1;

        public CustomStack(int maxSize) {
            stack = new int[maxSize];
        }

        public void push(int x) {
            if (currentElement < stack.length - 1) {
                currentElement++;
                stack[currentElement] = x;
            }
        }

        public int pop() {
            if (currentElement >= 0) {
                int popElem = stack[currentElement];
                currentElement--;
                return popElem;
            }
            return -1;
        }

        public void increment(int k, int val) {
            for (int i = 0; i < k && i < stack.length; i++) {
                stack[i] += val;
            }
        }
    }
}
