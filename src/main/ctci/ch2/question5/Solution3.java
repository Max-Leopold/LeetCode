package main.ctci.ch2.question5;

// reverse order
// without converting to Strings
// recursive

import main.util.java.ListNode;

public class Solution3 {

    static ListNode sumLists(ListNode firstHead, ListNode secondHead) {
        return buildList(getNum(firstHead, 1) + getNum(secondHead, 1));
    }

    private static int getNum(ListNode head, int depth) {
        if (head == null) {
            return 0;
        }

        int val = getNum(head.next, depth * 10);
        return head.val * depth + val;
    }

    private static ListNode buildList(int num) {
        ListNode head = new ListNode(num % 10);
        num = num / 10;

        ListNode previous = head;
        while (num > 9) {
            ListNode node = new ListNode(num % 10);
            previous.next = node;
            previous = node;
            num = num / 10;
        }
        previous.next = new ListNode(num);

        return head;
    }
}
