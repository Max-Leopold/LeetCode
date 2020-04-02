package main.problems.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * You have an infinite number of stacks arranged in a row and numbered (left to right) from 0,
 * each of the stacks has the same maximum capacity.
 *
 * Implement the DinnerPlates class:
 *
 * 1. DinnerPlates(int capacity) Initializes the object with the maximum capacity of the stacks.
 * 2. void push(int val) pushes the given positive integer
 *    val into the leftmost stack with size less than capacity.
 * 3. int pop() returns the value at the top of the rightmost non-empty stack and removes it
 *    from that stack, and returns -1 if all stacks are empty.
 * 4. int popAtStack(int index) returns the value at the top of the stack with the given index
 *    and removes it from that stack, and returns -1 if the stack with that given index is empty.
 *
 * Constraints:
 *
 * 1 <= capacity <= 20000
 * 1 <= val <= 20000
 * 0 <= index <= 100000
 * At most 200000 calls will be made to push, pop, and popAtStack.
 */

public class Nr1172 {

  static class DinnerPlates {

    private final int capacity;

    private int stackToPush;
    private int stackToPop;

    private List<Stack<Integer>> stacks;

    public DinnerPlates(int capacity) {
      this.capacity = capacity;

      this.stackToPop = 0;
      this.stackToPush = 0;

      this.stacks = new ArrayList<>();
      stacks.add(new Stack<>());
    }

    public void push(int val) {
      if(stacks.size() < stackToPush + 1) {
        stacks.add(stackToPush, new Stack<>());
        stackToPop++;
      }

      if(stacks.get(stackToPush).size() == capacity) {
        stackToPush++;
        push(val);
        return;
      }

      if(stackToPop < stackToPush) {
        stackToPop = stackToPush;
      }

      stacks.get(stackToPush).push(val);
    }

    public int pop() {
      if(stackToPop == -1) {
        stackToPop = 0;
        return -1;
      }

      if(stacks.size() < stackToPop + 1 || stacks.get(stackToPop) == null || stacks.get(stackToPop).isEmpty()) {
        stackToPop--;
        return pop();
      }

      int retVal = stacks.get(stackToPop).pop();
      if(stacks.get(stackToPop).isEmpty() && stackToPop <= stackToPush) {
        stackToPush--;
      }

      return retVal;
    }

    public int popAtStack(int index) {
      if(index + 1 > stacks.size() || stacks.get(index) == null || stacks.get(index).isEmpty()) {
        return -1;
      }

      if(stackToPush > index) {
        stackToPush = index;
      }

      return stacks.get(index).pop();
    }
  }

  /**
   * Your DinnerPlates object will be instantiated and called as such:
   * DinnerPlates obj = new DinnerPlates(capacity);
   * obj.push(val);
   * int param_2 = obj.pop();
   * int param_3 = obj.popAtStack(index);
   */

  public static void main(String[] args) {
    DinnerPlates dinnerPlates = new DinnerPlates(1);

    dinnerPlates.push(1);
    dinnerPlates.push(2);

    System.out.println(dinnerPlates.popAtStack(1));

    System.out.println(dinnerPlates.pop());

    dinnerPlates.push(1);
    dinnerPlates.push(2);

    System.out.println(dinnerPlates.pop());
    System.out.println(dinnerPlates.pop());
  }
}
