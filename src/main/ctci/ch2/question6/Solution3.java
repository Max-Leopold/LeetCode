package main.ctci.ch2.question6;

// With fixed size array

import main.util.java.ListNode;

public class Solution3 {

    static boolean isPalindrome(ListNode head) {
        if (head == null) {
            throw new IllegalArgumentException();
        }

        int listSize = 0;

        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            listSize++;
        }

        if (fastPointer != null) {
            slowPointer = slowPointer.next;
        }

        int[] palindrome = new int[listSize];
        boolean[] valueSet = new boolean[listSize];

        for (int i = 0; slowPointer != null; i++) {
            if (!valueSet[i]) {
                valueSet[i] = true;
                palindrome[i] = head.val;
            } else {
                if (palindrome[i] != head.val) {
                    return false;
                }
            }

            if (!valueSet[valueSet.length - 1 - i]) {
                valueSet[valueSet.length - 1 - i] = true;
                palindrome[valueSet.length - 1 - i] = slowPointer.val;
            } else {
                if (palindrome[valueSet.length - 1 - i] != slowPointer.val) {
                    return false;
                }
            }

            slowPointer = slowPointer.next;
            head = head.next;
        }

        return true;
    }
}
