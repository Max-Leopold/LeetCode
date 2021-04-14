package main.ctci.ch2.question5;

// not reversed order

import main.util.java.ListNode;

public class Solution2 {

    static ListNode sumLists(ListNode firstHead, ListNode secondHead) {
        return buildList(getNum(firstHead) + getNum(secondHead));
    }

    private static int getNum(ListNode head) {
        StringBuilder sb = new StringBuilder("0");

        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }

        return Integer.parseInt(sb.toString());
    }

    private static ListNode buildList(int num) {
        ListNode head = new ListNode(num % 10);
        num = num / 10;

        ListNode previous = head;
        while (num > 9) {
            ListNode node = new ListNode(num % 10);
            node.next = previous;
            previous = node;
            num = num / 10;
        }
        return new ListNode(num, previous);
    }
}
