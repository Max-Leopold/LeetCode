package main.problems.java;

import main.util.java.ListNode;

public class Nr328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddList = new ListNode(-1);
        ListNode evenList = new ListNode(-1);
        ListNode oddListCurrent = oddList;
        ListNode evenListCurrent = evenList;

        int currentIndex = 1;
        while (head != null) {
            if (currentIndex % 2 == 0) {
                evenListCurrent.next = head;
                evenListCurrent = head;
            } else {
                oddListCurrent.next = head;
                oddListCurrent = head;
            }

            currentIndex++;
            head = head.next;
        }

        oddListCurrent.next = evenList.next;
        evenListCurrent.next = null;

        return oddList.next;
    }
}
