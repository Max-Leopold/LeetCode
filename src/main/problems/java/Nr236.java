package main.problems.java;

import main.util.java.TreeNode;

public class Nr236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }

        boolean pIsInRightTree = isInTree(root.right, p);
        boolean qIsInRightTree = isInTree(root.right, q);
        if (qIsInRightTree && pIsInRightTree) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (!qIsInRightTree && !pIsInRightTree) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }

    }

    private boolean isInTree(TreeNode root, TreeNode searching) {
        if (root == null) {
            return false;
        }
        if (root == searching) {
            return true;
        }
        return isInTree(root.right, searching) || isInTree(root.left, searching);
    }
}
