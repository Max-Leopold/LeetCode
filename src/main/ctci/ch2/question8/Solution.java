package main.ctci.ch2.question8;

import main.util.java.ListNode;

// Questions:
// Does the list guarantee a loop? (No, return null if no loop)

public class Solution {

    static ListNode getLoopNode(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        do {
            if (fastPointer == null || fastPointer.next == null) {
                return null;
            }
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        } while (slowPointer != fastPointer);

        slowPointer = head;
        while (slowPointer != fastPointer) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        return slowPointer;
    }
}
