package main.problems.java;

import main.util.java.ListNode;
import main.util.java.ListNodeBuilder;
import main.util.java.ListNodePrinter;

public class Nr24 {

    public static void main(String[] args) {
        Nr24 nr24 = new Nr24();
        ListNodePrinter.print(
                nr24.swapPairs(ListNodeBuilder.buildList(new int[]{2, 1, 4, 3, 6, 5}))
        );
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode ans = new ListNode(-1);
        ans.next = head;
        ListNode newHead = ans;

        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            head = second.next;
            second.next = first;
            first.next = head;
            newHead.next = second;
            newHead = first;
        }

        return ans.next;
    }
}
