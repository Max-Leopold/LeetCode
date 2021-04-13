package main.ctci.ch2.question2;

import main.util.java.ListNode;

// O(n) time, O(n) space

public class Solution2 {

    static ListNode kthToLast(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        return walkList(head, new KIndex(k, -1));
    }

    private static ListNode walkList(ListNode head, KIndex kIndex) {
        if (head == null) {
            kIndex.indexFromBack = 0;
            return head;
        }

        ListNode node = walkList(head.next, kIndex);
        kIndex.indexFromBack += 1;
        if (kIndex.k == kIndex.indexFromBack) {
            return head;
        }
        return node;
    }

    static class KIndex {

        int k;
        int indexFromBack;

        public KIndex(int k, int indexFromBack) {
            this.k = k;
            this.indexFromBack = indexFromBack;
        }
    }

}
