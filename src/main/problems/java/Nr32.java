package main.problems.java;

import java.util.Stack;

public class Nr32 {

    public static void main(String[] args) {
        Nr32 nr32 = new Nr32();
        System.out.println(nr32.longestValidParentheses("(()()(()()()())"));
    }

    public int longestValidParentheses(String s) {
        int maxLength = 0;
        int opener = 0;
        Stack<LengthAndOpener> lengths = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ')' && opener == 0) {
                lengths = new Stack<>();
                continue;
            }
            if (c == '(') {
                opener++;
            }
            if (c == ')') {
                opener--;
                LengthAndOpener lengthAndOpener = new LengthAndOpener(2, opener);
                lengths.push(lengthAndOpener);
                compressStack(lengths);
                maxLength = Math.max(maxLength, lengths.peek().length);
            }
        }
        return maxLength;
    }

    private void compressStack(Stack<LengthAndOpener> stack) {
        while (stack.size() > 1) {
            LengthAndOpener top = stack.pop();
            if (top.opener <= stack.peek().opener) {
                LengthAndOpener second = stack.pop();
                LengthAndOpener newTop = new LengthAndOpener(
                        top.length + second.length,
                        top.opener
                );
                stack.push(newTop);
            } else {
                stack.push(top);
                break;
            }
        }
    }

    private static class LengthAndOpener {
        int length;
        int opener;

        public LengthAndOpener(int length, int opener) {
            this.length = length;
            this.opener = opener;
        }
    }
}
