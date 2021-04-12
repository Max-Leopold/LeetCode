package main.ctci.ch2.question1;

import main.util.java.ListNode;
import main.util.java.ListNodePrinter;

public class Main {

    public static void main(String[] args) {
        ListNodePrinter.print(Solution1.removeDups(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(1,
                                                new ListNode(4,
                                                        new ListNode(3,
                                                                new ListNode(3,
                                                                        new ListNode(3
                                                                        )))))))))
        );

        ListNodePrinter.print(Solution2.removeDups(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(1,
                                                new ListNode(4,
                                                        new ListNode(3,
                                                                new ListNode(3,
                                                                        new ListNode(3
                                                                        )))))))))
        );
    }
}
