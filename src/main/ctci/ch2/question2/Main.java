package main.ctci.ch2.question2;

import main.util.java.ListNodeBuilder;
import main.util.java.ListNodePrinter;

public class Main {

    public static void main(String[] args) {
        ListNodePrinter.print(Solution1.kthToLast(
                ListNodeBuilder.buildList(new int[]{1, 2, 3, 1, 4, 3, 3, 3}),
                5
        ));

        ListNodePrinter.print(Solution2.kthToLast(
                ListNodeBuilder.buildList(new int[]{1, 2, 3, 1, 4, 3, 3, 3}),
                5
        ));
    }
}
