package main.ctci.ch2.question8;

import main.util.java.ListNode;

public class Main {

    public static void main(String[] args) {
        ListNode listNodeHeadWithLoop = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);
        ListNode eight = new ListNode(8);
        ListNode nine = new ListNode(9);

        listNodeHeadWithLoop.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = four;

        System.out.println(Solution.getLoopNode(listNodeHeadWithLoop));
    }
}
