package main.ctci.ch4.question5;

import main.util.java.BinaryTreeNode;

public class Solution2 {

    static boolean validateBST(BinaryTreeNode root, InOrderLast last) {
        if (root == null) {
            return true;
        }

        if (!validateBST(root.getLeft(), last)) return false;

        if (last.value != null && root.getVal() < last.value) {
            return false;
        }

        last.value = root.getVal();

        if (!validateBST(root.getRight(), last)) return false;

        return true;
    }

    public static class InOrderLast {
        public Integer value = null;
    }
}
