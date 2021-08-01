package main.problems.java;

import main.util.java.ListNode;

public class Nr83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode firstOcc = head;
        ListNode lastOcc = head;
        while (lastOcc != null) {
            if (lastOcc.val == firstOcc.val) {
                lastOcc = lastOcc.next;
            } else {
                firstOcc.next = lastOcc;
                firstOcc = lastOcc;
            }
        }

        if (firstOcc != null) {
            firstOcc.next = null;
        }
        return head;
    }
}
