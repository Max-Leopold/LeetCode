package main.ctci.ch3.question5;

import java.util.Arrays;
import java.util.Stack;

public class StackWithSort<T extends Comparable<T>> extends Stack<T> {

    public void sortStack() {
        if (this.isEmpty()) {
            return;
        }

        Stack<T> temporaryStack = new Stack<>();

        while (!this.isEmpty()) {
            T nextItem = this.pop();
            if (temporaryStack.isEmpty()) {
                temporaryStack.push(nextItem);
                continue;
            }
            shiftStack(temporaryStack, nextItem);
            temporaryStack.push(nextItem);
        }

        while (!temporaryStack.isEmpty()) {
            this.push(temporaryStack.pop());
        }
    }

    public void shiftStack(Stack<T> temporaryStack, T nextItem) {
        while (!temporaryStack.isEmpty() && temporaryStack.peek().compareTo(nextItem) > 0) {
            this.push(temporaryStack.pop());
        }
    }

    @Override
    public String toString() {
        return "StackWithSort{" +
                "elementData=" + Arrays.toString(elementData) +
                '}';
    }
}
