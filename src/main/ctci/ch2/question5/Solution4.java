package main.ctci.ch2.question5;

// Linear
// reversed order

import main.util.java.ListNode;

public class Solution4 {

    static ListNode sumLists(ListNode firstHead, ListNode secondHead) {
        return buildList(getNum(firstHead) + getNum(secondHead));
    }

    private static int getNum(ListNode head) {
        int num = 0;

        for (int i = 0; head != null; i++) {
            num = num + head.val * (int) Math.pow(10, i);
            head = head.next;
        }

        return num;
    }

    private static ListNode buildList(int num) {
        ListNode head = num < 10 ? new ListNode(num) : new ListNode(num % 10);
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
