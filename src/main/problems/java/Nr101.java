package main.problems.java;

import main.util.java.TreeNode;

public class Nr101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode root, TreeNode mirrorRoot) {
        if (root == null && mirrorRoot == null) {
            return true;
        }
        if (root == null || mirrorRoot == null) {
            return false;
        }
        if (root.val != mirrorRoot.val) {
            return false;
        }

        return isSymmetric(root.left, mirrorRoot.right) && isSymmetric(root.right, mirrorRoot.left);
    }
}
