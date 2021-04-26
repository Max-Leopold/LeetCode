package main.ctci.ch4.question6;

import main.util.java.BinaryTreeNode;

public class Solution {

    static BinaryTreeNode inOrderSuccesor(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode.getRight() != null) {
            BinaryTreeNode succesor = binaryTreeNode.getRight();
            while (succesor.getLeft() != null) {
                succesor = succesor.getLeft();
            }

            return succesor;
        } else {
            while (binaryTreeNode.getParent() != null) {
                if (isLeftChild(binaryTreeNode)) {
                    return binaryTreeNode.getParent();
                }
                binaryTreeNode = binaryTreeNode.getParent();
            }
        }

        return null;
    }

    private static boolean isLeftChild(BinaryTreeNode child) {
        return child.getParent().getLeft() == child;
    }
}
