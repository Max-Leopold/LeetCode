package main.ctci.ch2.question5;


import main.util.java.ListNodeBuilder;
import main.util.java.ListNodePrinter;

public class Main {

    public static void main(String[] args) {
        ListNodePrinter.print(Solution1.sumLists(
                ListNodeBuilder.buildList(new int[]{6, 1, 7}),
                ListNodeBuilder.buildList(new int[]{2, 9, 5, 6})
        ));

        ListNodePrinter.print(Solution2.sumLists(
                ListNodeBuilder.buildList(new int[]{7, 1, 6}),
                ListNodeBuilder.buildList(new int[]{6, 5, 9, 2})
        ));

        ListNodePrinter.print(Solution3.sumLists(
                ListNodeBuilder.buildList(new int[]{6, 1, 7}),
                ListNodeBuilder.buildList(new int[]{2, 9, 5, 6})
        ));

        ListNodePrinter.print(Solution4.sumLists(
                ListNodeBuilder.buildList(new int[]{6, 1, 7}),
                ListNodeBuilder.buildList(new int[]{2, 9, 5, 6})
        ));

        ListNodePrinter.print(Solution5.sumLists(
                ListNodeBuilder.buildList(new int[]{6, 1, 7}),
                ListNodeBuilder.buildList(new int[]{2, 9, 5, 6})
        ));
    }
}
