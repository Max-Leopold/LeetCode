package main.problems.java;

import main.util.java.ListNode;
import main.util.java.ListNodeBuilder;
import main.util.java.ListNodePrinter;

public class Nr206 {

    public static void main(String[] args) {
        Nr206 nr206 = new Nr206();
        ListNode head = ListNodeBuilder.buildList(new int[]{1, 2, 3, 4, 5});
        ListNodePrinter.print(nr206.reverseList2(head));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode end = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return end;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode tmpNext = current.next;
            current.next = prev;
            prev = current;
            current = tmpNext;
        }

        return prev;
    }
}
