package main.ctci.ch2.question7;

import main.util.java.ListNode;
import main.util.java.ListNodePrinter;

public class Main {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        ListNode headTwo = new ListNode(6);
        ListNode seven = new ListNode(7);
        ListNode eight = new ListNode(8);
        ListNode nine = new ListNode(9);

        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        headTwo.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = three;

        ListNodePrinter.print(Solution1.getIntersection(head, headTwo));
        ListNodePrinter.print(Solution2.getIntersection(head, headTwo));
    }
}
