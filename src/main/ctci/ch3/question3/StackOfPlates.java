package main.ctci.ch3.question3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// Questions
// if we popAt(int index) should we also insert the next value at the stack with the lowest index which still has capacity? (Yes)


public class StackOfPlates<T> {

    private final int stackSize;
    private final List<StackAndSize> stacks;
    private int pushTo = 0;

    public StackOfPlates(int stackSize) {
        this.stackSize = stackSize;
        stacks = new ArrayList<>();

        stacks.add(new StackAndSize());
    }

    public void push(T data) {
        while (stacks.get(pushTo).size == stackSize) {
            pushTo++;
            if (pushTo == stacks.size()) {
                stacks.add(new StackAndSize());
            }
        }

        stacks.get(pushTo).push(data);
    }

    public T pop() {
        T item = stacks.get(stacks.size() - 1).pop();
        if (stacks.get(stacks.size() - 1).size == 0) {
            if (pushTo == stacks.size() - 1) {
                pushTo--;
            }
            stacks.remove(stacks.size() - 1);
        }
        return item;
    }

    public T popAtIndex(int index) {
        T item = stacks.get(index).pop();
        if (index < pushTo) {
            pushTo = index;
        }
        return item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return "StackOfPlates{" +
                "stackSize=" + stackSize +
                ", stacks=" + stacks +
                ", pushTo=" + pushTo +
                '}';
    }

    private class StackAndSize extends Stack<T> {
        public int size;

        public StackAndSize() {
            size = 0;
        }

        @Override
        public T push(T item) {
            size++;

            return super.push(item);
        }

        @Override
        public synchronized T pop() {
            size--;

            return super.pop();
        }

        @Override
        public String toString() {
            return "StackAndSize{" +
                    "size=" + size +
                    ", elementData=" + Arrays.toString(elementData) +
                    '}';
        }
    }
}
