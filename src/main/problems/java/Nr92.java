package main.problems.java;

import main.util.java.ListNode;
import main.util.java.ListNodeBuilder;
import main.util.java.ListNodePrinter;

public class Nr92 {

    public static void main(String[] args) {
        Nr92 nr92 = new Nr92();
        ListNode head = ListNodeBuilder.buildList(
                new int[]{5}
        );
        head = nr92.reverseBetween(head, 1, 1);
        ListNodePrinter.print(head);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }

        ListNode beforeReverseStart = null;
        ListNode reverseStart = head;
        for (int i = 1; i < left; i++) {
            beforeReverseStart = reverseStart;
            reverseStart = reverseStart.next;
        }

        ReverseHeadAndTail reverseHeadAndTail = reverseFromUntil(reverseStart, right - left);
        if (left == 1) {
            return reverseHeadAndTail.start;
        } else {
            beforeReverseStart.next = reverseHeadAndTail.start;
            return head;
        }
    }

    private ReverseHeadAndTail reverseFromUntil(ListNode reverseStart, int counter) {
        ReverseHeadAndTail reverseHeadAndTail = new ReverseHeadAndTail();
        reverseHeadAndTail.end = reverseStart;
        ListNode next;
        ListNode prev = reverseStart;
        for (; counter >= 0; counter--) {
            next = reverseStart.next;
            reverseStart.next = prev;
            prev = reverseStart;
            reverseStart = next;

            reverseHeadAndTail.end.next = next;
        }
        reverseHeadAndTail.start = prev;
        return reverseHeadAndTail;
    }

    private class ReverseHeadAndTail {
        private ListNode start;
        private ListNode end;
    }
}
