package main.problems.java;

import main.util.java.ListNode;

public class Nr141 {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) return false;

        ListNode slowPointer = head;
        ListNode fastPointer = head.next;

        while (true) {
            if (slowPointer == fastPointer) return true;

            if (fastPointer == null || fastPointer.next == null) return false;

            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
    }
}
