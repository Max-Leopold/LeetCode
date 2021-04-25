package main.ctci.ch4.question5;

import main.util.java.BinaryTreeNode;

public class Solution {

    static boolean validateBST(BinaryTreeNode root, Integer max, Integer min) {
        if (root == null) {
            return true;
        }

        if ((max != null && root.getVal() >= max) || (min != null && root.getVal() < min)) {
            return false;
        }

        boolean leftIsBST = validateBST(root.getLeft(), root.getVal(), min);
        boolean rightIsBST = validateBST(root.getRight(), max, root.getVal());

        if (root.getLeft() != null && root.getLeft().getVal() > root.getVal()) {
            return false;
        }
        if (root.getRight() != null && root.getRight().getVal() <= root.getVal()) {
            return false;
        }

        return leftIsBST && rightIsBST;
    }
}
