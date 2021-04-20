package main.ctci.ch3.question4;

import java.util.Stack;

public class MyQueue2<T> {

    private final Stack<T> queue;
    private final Stack<T> stack;

    public MyQueue2() {
        this.queue = new Stack<>();
        this.stack = new Stack<>();
    }

    public void add(T item) {
        stack.add(item);
    }

    public T remove() {
        moveStackToQ();
        return queue.pop();
    }

    public T peek() {
        moveStackToQ();
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    private void moveStackToQ() {
        if (queue.isEmpty()) {
            while (!stack.isEmpty()) {
                queue.push(stack.pop());
            }
        }
    }
}

