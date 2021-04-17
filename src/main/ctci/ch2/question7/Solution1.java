package main.ctci.ch2.question7;

import java.util.HashSet;
import java.util.Set;

import main.util.java.ListNode;

public class Solution1 {

    static ListNode getIntersection(ListNode headOne, ListNode headTwo) {
        Set<ListNode> seen = new HashSet<>();

        while (headOne != null) {
            seen.add(headOne);
            headOne = headOne.next;
        }

        while (headTwo != null) {
            if (seen.contains(headTwo)) {
                return headTwo;
            }
            headTwo = headTwo.next;
        }

        return null;
    }
}
