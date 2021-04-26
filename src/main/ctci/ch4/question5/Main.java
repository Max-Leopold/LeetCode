package main.ctci.ch4.question5;

import main.util.java.BinaryTreeBuilder;
import main.util.java.BinaryTreeNode;
import main.util.java.BinaryTreePrinter;

public class Main {

    public static void main(String[] args) {
        BinaryTreeNode noBstRoot = BinaryTreeBuilder.insertLevelOrder(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},
                new BinaryTreeNode(1),
                0,
                null);
        BinaryTreePrinter.printNode(noBstRoot);

        System.out.println(Solution.validateBST(noBstRoot, null, null));
        System.out.println(Solution2.validateBST(noBstRoot, new Solution2.InOrderLast()));

        BinaryTreeNode bstRoot = BinaryTreeBuilder.insertLevelOrder(
                new int[]{10, 5, 15, 2, 7, 12, 17, 1, 3},
                new BinaryTreeNode(1),
                0,
                null);
        BinaryTreePrinter.printNode(bstRoot);

        System.out.println(Solution.validateBST(bstRoot, null, null));
        System.out.println(Solution2.validateBST(bstRoot, new Solution2.InOrderLast()));

        BinaryTreeNode noBstRoot2 = BinaryTreeBuilder.insertLevelOrder(
                new int[]{20, 10, 30, 1, 25},
                new BinaryTreeNode(1),
                0,
                null);
        BinaryTreePrinter.printNode(noBstRoot2);

        System.out.println(Solution.validateBST(noBstRoot2, null, null));
        System.out.println(Solution2.validateBST(noBstRoot2, new Solution2.InOrderLast()));
    }
}
