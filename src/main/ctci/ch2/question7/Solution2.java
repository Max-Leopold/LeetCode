package main.ctci.ch2.question7;

import main.util.java.ListNode;

// Questions
// Will there always be an intersection? (No)

public class Solution2 {

    static ListNode getIntersection(ListNode head, ListNode headTwo) {
        TailAndSize tailAndSizeFirstList = getTailAndSize(head);
        TailAndSize tailAndSizeSecondList = getTailAndSize(headTwo);

        if (tailAndSizeFirstList.tail != tailAndSizeSecondList.tail) {
            return null;
        }

        if (tailAndSizeFirstList.size > tailAndSizeSecondList.size) {
            for (int i = 0; i < tailAndSizeFirstList.size - tailAndSizeSecondList.size; i++) {
                head = head.next;
            }
        } else {
            for (int i = 0; i < tailAndSizeSecondList.size - tailAndSizeFirstList.size; i++) {
                headTwo = headTwo.next;
            }
        }
        return getIntersectionNode(head, headTwo);
    }

    private static ListNode getIntersectionNode(ListNode head, ListNode headTwo) {
        while (head != null && headTwo != null) {
            if (head == headTwo) {
                return head;
            }
            head = head.next;
            headTwo = headTwo.next;
        }

        return null;
    }

    private static TailAndSize getTailAndSize(ListNode head) {
        int counter = 0;
        while (head.next != null) {
            counter++;
            head = head.next;
        }
        return new TailAndSize(counter, head);
    }

    private static class TailAndSize {
        private final int size;
        private final ListNode tail;

        public TailAndSize(int size, ListNode tail) {
            this.size = size;
            this.tail = tail;
        }
    }
}
