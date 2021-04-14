package main.ctci.ch2.question5;

import main.util.java.ListNode;

// Reverse order

// Build list and addition in one step

public class Solution5 {

    static ListNode sumLists(ListNode firstHead, ListNode secondHead) {
        int tooMuch = 0;
        ListNode head = null;
        ListNode previous = null;
        boolean headInitialized = false;

        while (firstHead != null && secondHead != null) {
            int sum = firstHead.val + secondHead.val + tooMuch;
            tooMuch = sum / 10;
            sum %= 10;

            if (!headInitialized) {
                head = new ListNode(sum);
                previous = head;
                headInitialized = true;
            } else {
                previous.next = new ListNode(sum);
                previous = previous.next;
            }

            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }

        if (firstHead == null && secondHead == null) {
            previous.next = new ListNode(tooMuch);
        }

        if (firstHead == null && secondHead != null) {
            if (headInitialized) {
                secondHead.val++;
                previous.next = secondHead;
            } else {
                secondHead.val++;
                return secondHead;
            }
        } else if (secondHead == null && firstHead != null) {
            if (headInitialized) {
                firstHead.val++;
                previous.next = firstHead;
            } else {
                firstHead.val++;
                return firstHead;
            }
        }

        return head;
    }
}
