package main.ctci.ch2.question3;

import main.util.java.ListNode;
import main.util.java.ListNodeBuilder;
import main.util.java.ListNodePrinter;

public class Main {

    public static void main(String[] args) {

        ListNode head = ListNodeBuilder.buildList(new int[]{1, 2, 3, 1, 4, 3, 3, 3});
        ListNode nodeInMiddle = head.next.next.next;
        Solution1.deleteMiddleNode(nodeInMiddle);
        ListNodePrinter.print(head);
    }
}
