package main.ctci.ch4.question4;

import main.util.java.BinaryTreeBuilder;
import main.util.java.BinaryTreeNode;
import main.util.java.BinaryTreePrinter;

public class Main {

    public static void main(String[] args) {
        System.out.println(
                Solution1.checkBalanced(
                        BinaryTreeBuilder.insertLevelOrder(
                                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},
                                new BinaryTreeNode(1),
                                0
                        )
                )
        );

        BinaryTreeNode root = new BinaryTreeNode(0);
        BinaryTreeNode one = new BinaryTreeNode(1);
        BinaryTreeNode two = new BinaryTreeNode(2);
        BinaryTreeNode three = new BinaryTreeNode(3);
        BinaryTreeNode four = new BinaryTreeNode(4);
        BinaryTreeNode five = new BinaryTreeNode(5);
        BinaryTreeNode six = new BinaryTreeNode(6);

        root.setLeft(one);
        one.setRight(two);
        two.setRight(three);
        two.setLeft(four);
        four.setRight(six);
        root.setRight(five);

        BinaryTreePrinter.printNode(root);

        System.out.println(Solution1.checkBalanced(root));

    }
}
