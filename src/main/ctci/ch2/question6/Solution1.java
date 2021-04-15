package main.ctci.ch2.question6;

import main.util.java.ListNode;

// With LinkedList

public class Solution1 {

    static boolean isPalindrome(ListNode head) {
        if (head == null) {
            throw new IllegalArgumentException();
        }

        ListNode secondList = null;

        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            ListNode newSecondListHead = new ListNode(slowPointer.val, secondList);
            secondList = newSecondListHead;

            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        if (fastPointer != null) {
            slowPointer = slowPointer.next;
        }

        while (slowPointer != null) {
            if (slowPointer.val != secondList.val) {
                return false;
            }

            slowPointer = slowPointer.next;
            secondList = secondList.next;
        }

        return true;
    }
}
