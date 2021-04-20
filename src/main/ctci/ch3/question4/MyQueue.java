package main.ctci.ch3.question4;

import java.util.Stack;

public class MyQueue<T> {

    private final Stack<T> queue;
    private final Stack<T> temporaryStack;

    public MyQueue() {
        this.queue = new Stack<>();
        this.temporaryStack = new Stack<>();
    }

    public void add(T item) {
        while (!queue.isEmpty()) {
            temporaryStack.push(queue.pop());
        }
        queue.add(item);
        while (!temporaryStack.isEmpty()) {
            queue.push(temporaryStack.pop());
        }
    }

    public T remove() {
        return queue.pop();
    }

    public T peek() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
