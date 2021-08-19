package main.problems.java;

import main.util.java.ListNode;

public class Nr445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int length1 = getLength(l1);
        int length2 = getLength(l2);
        l1 = pad(l1, length2 - length1);
        l2 = pad(l2, length1 - length2);
        int carryOver = add(l1, l2);
        if (carryOver > 0) {
            ListNode head = new ListNode(carryOver);
            head.next = l1;
            return head;
        }
        return l1;
    }

    private int add(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return 0;
        }
        int carryOver = add(head1.next, head2.next);
        int sum = carryOver + head1.val + head2.val;
        int val = sum % 10;
        int returnCarryOver = sum / 10;
        head1.val = val;
        return returnCarryOver;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    private ListNode pad(ListNode head, int paddings) {
        while (paddings > 0) {
            ListNode newHead = new ListNode(0);
            newHead.next = head;
            head = newHead;
            paddings--;
        }
        return head;
    }
}
