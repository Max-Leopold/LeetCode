package main.ctci.ch2.question4;

// Questions
// Are the elements in the List unique? (No)
// Is the length of the list known? (No)

import main.util.java.ListNode;

public class Solution1 {

    static ListNode partition(ListNode head, int partition) {
        if (head == null) {
            throw new IllegalArgumentException();
        }
        ListNode currentFirst = head;
        ListNode previous = null;
        while (head != null) {
            if (head.val < partition && previous != null) {
                previous.next = head.next;
                head.next = currentFirst;
                currentFirst = head;
                head = previous;
            } else {
                previous = head;
            }
            head = head.next;
        }

        return currentFirst;
    }
}
