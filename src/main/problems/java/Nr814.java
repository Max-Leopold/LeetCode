package main.problems.java;

import main.util.java.TreeNode;

public class Nr814 {

    public TreeNode pruneTree(TreeNode root) {
        boolean hasAtLeastOneOne = hasOne(root);
        if (hasAtLeastOneOne) {
            return root;
        }
        return null;
    }

    public boolean hasOne(TreeNode root) {
        if (root == null) {
            return false;
        }

        boolean leftHasOne = hasOne(root.left);
        boolean rightHasOne = hasOne(root.right);

        if (!leftHasOne) {
            root.left = null;
        }
        if (!rightHasOne) {
            root.right = null;
        }

        return root.val == 1 || leftHasOne || rightHasOne;
    }
}
