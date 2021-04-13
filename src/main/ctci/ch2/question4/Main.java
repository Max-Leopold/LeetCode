package main.ctci.ch2.question4;

import main.util.java.ListNodeBuilder;
import main.util.java.ListNodePrinter;

public class Main {

    public static void main(String[] args) {
        ListNodePrinter.print(
                Solution1.partition(
                        ListNodeBuilder.buildList(new int[]{3, 5, 8, 5, 10, 2, 1}),
                        5
                )
        );
    }
}
