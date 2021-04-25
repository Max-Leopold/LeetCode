package main.ctci.ch4.question4;

import main.util.java.BinaryTreeNode;

public class Solution1 {

    static boolean checkBalanced(BinaryTreeNode root) {
        return calculateHeights(root) != -1;
    }

    private static int calculateHeights(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = calculateHeights(root.getLeft());
        int rightHeight = calculateHeights(root.getRight());

        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
