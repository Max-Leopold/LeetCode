package main.ctci.ch3.question2;

import java.util.Stack;

public class StackMin<T extends Comparable<T>> extends Stack<T> {

    private final Stack<T> minStack;

    public StackMin() {
        this.minStack = new Stack<>();
    }

    @Override
    public T push(T item) {
        if (minStack.isEmpty()) {
            minStack.push(item);
        } else {
            if (minStack.peek().compareTo(item) != -1) {
                minStack.push(item);
            }
        }

        return super.push(item);
    }

    @Override
    public synchronized T pop() {
        if (minStack.peek() == super.peek()) {
            minStack.pop();
        }

        return super.pop();
    }

    public T min() {
        return minStack.peek();
    }
}
