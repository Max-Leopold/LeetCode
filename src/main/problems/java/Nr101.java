package main.problems.java;

import java.util.LinkedList;
import java.util.Queue;

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

    public boolean isSymetricIterative(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }
            if ((node1.left == null && node2.right != null)
                    || (node1.right == null && node2.left != null)
                    || (node2.left == null && node1.right != null)
                    || (node2.right == null && node1.left != null)) {
                return false;
            }

            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }

        return true;
    }
}
