package main.ctci.ch2.question1;

// With temporary Buffer O(n) time, O(n) space

import java.util.HashSet;
import java.util.Set;

import main.util.java.ListNode;

public class Solution1 {

    static ListNode removeDups(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode returnHead = head;

        Set<Integer> seen = new HashSet<>();
        seen.add(head.val);

        while (head.next != null) {
            if (seen.contains(head.next.val)) {
                head.next = head.next.next;
            } else {
                seen.add(head.next.val);
                head = head.next;
            }
        }

        return returnHead;
    }
}
