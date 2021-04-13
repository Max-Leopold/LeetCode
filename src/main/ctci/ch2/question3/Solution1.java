package main.ctci.ch2.question3;

import main.util.java.ListNode;

// Last node doesn't work

public class Solution1 {

    static void deleteMiddleNode(ListNode node) {
        if (node == null || node.next == null) {
            throw new IllegalArgumentException();
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
