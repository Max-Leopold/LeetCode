package main.ctci.ch2.question1;

// Without Buffer O(n^2) time, O(1) space

import main.util.java.ListNode;

public class Solution2 {

    static ListNode removeDups(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode returnHead = head;

        while (head != null) {
            ListNode nextHead = head;
            while (nextHead.next != null) {
                if (head.val == nextHead.next.val) {
                    nextHead.next = nextHead.next.next;
                } else {
                    nextHead = nextHead.next;
                }
            }
            head = head.next;
        }

        return returnHead;
    }
}
