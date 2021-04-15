package main.ctci.ch2.question6;

import java.util.ArrayList;
import java.util.List;

import main.util.java.ListNode;

// With Array List

public class Solution2 {

    static boolean isPalindrome(ListNode head) {
        if (head == null) {
            throw new IllegalArgumentException();
        }

        List<Integer> secondList = new ArrayList<>();

        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            secondList.add(slowPointer.val);

            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        if (fastPointer != null) {
            slowPointer = slowPointer.next;
        }

        for (int i = 0; slowPointer != null; i++) {
            if (slowPointer.val != secondList.get(secondList.size() - 1 - i)) {
                return false;
            }
            slowPointer = slowPointer.next;
        }

        return true;
    }
}
