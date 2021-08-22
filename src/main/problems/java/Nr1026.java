package main.problems.java;

import main.util.java.TreeNode;

public class Nr1026 {
    public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiff(root, root.val, root.val);
    }

    public int maxAncestorDiff(TreeNode root, int minVal, int maxVal) {
        if (root == null) {
            return 0;
        }

        int maxDiff = Math.max(Math.abs(minVal - root.val), Math.abs(maxVal - root.val));
        minVal = Math.min(root.val, minVal);
        maxVal = Math.max(root.val, maxVal);

        return Math.max(maxDiff, Math.max(
                maxAncestorDiff(root.left, minVal, maxVal),
                maxAncestorDiff(root.right, minVal, maxVal)
        ));
    }
}
