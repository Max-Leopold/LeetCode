package main.ctci.ch4.question6;

import main.util.java.BinaryTreeBuilder;
import main.util.java.BinaryTreeNode;
import main.util.java.BinaryTreePrinter;

public class Main {

    public static void main(String[] args) {
        BinaryTreeNode binaryTreeNode = BinaryTreeBuilder.insertLevelOrder(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},
                null,
                0,
                null);
        BinaryTreePrinter.printNode(binaryTreeNode);
        BinaryTreePrinter.printInOrder(binaryTreeNode);
        while (binaryTreeNode.getLeft() != null) binaryTreeNode = binaryTreeNode.getLeft();
        System.out.println();
        while (binaryTreeNode != null) {
            System.out.println(binaryTreeNode);
            binaryTreeNode = Solution.inOrderSuccesor(binaryTreeNode);
        }
    }
}
