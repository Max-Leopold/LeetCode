package main.ctci.ch2.question5;

import main.util.java.ListNode;

// Reversed order

// Questions:
// Doe the numbers always fit in integer? (Yes)

public class Solution1 {

    static ListNode sumLists(ListNode firstHead, ListNode secondHead) {
        return buildList(getNum(firstHead) + getNum(secondHead));
    }

    private static int getNum(ListNode head) {
        StringBuilder sb = new StringBuilder("0");

        while (head != null) {
            sb.insert(1, head.val);
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
            previous.next = node;
            previous = node;
            num = num / 10;
        }
        previous.next = new ListNode(num);

        return head;
    }
}
