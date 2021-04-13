package main.ctci.ch2.question2;

import main.util.java.ListNode;

// Questions:
// Is k always < list.length? (Assumption yes)
// Is the length of the list known? (Assumption no)
// Is the last element 0 from last or 1?

// O(n) time, O(1) space

public class Solution1 {

    static ListNode kthToLast(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode slowPointer = head, fastPointer = head;
        for (int i = 0; i < k; i++) {
            fastPointer = fastPointer.next;
        }
        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }

        return slowPointer;
    }
}
