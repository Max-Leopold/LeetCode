package main.ctci.ch2.question1;

import main.util.java.ListNodeBuilder;
import main.util.java.ListNodePrinter;

public class Main {

    public static void main(String[] args) {
        ListNodePrinter.print(Solution1.removeDups(
                ListNodeBuilder.buildList(new int[]{1, 2, 3, 1, 4, 3, 3, 3})
        ));

        ListNodePrinter.print(Solution2.removeDups(
                ListNodeBuilder.buildList(new int[]{1, 2, 3, 1, 4, 3, 3, 3})
        ));
    }
}
