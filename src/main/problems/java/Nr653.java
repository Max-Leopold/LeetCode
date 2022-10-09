package main.problems.java;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import main.util.java.TreeNode;

public class Nr653 {
    // Iterative
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> seen = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (top == null) continue;

            if (seen.contains(k - top.val)) return true;

            seen.add(top.val);
            queue.offer(top.left);
            queue.offer(top.right);
        }

        return false;
    }

    // Recursive
    public boolean findTargetRecursive(TreeNode root, int k) {
        return recursiveHelper(root, k, new HashSet<>());
    }

    private boolean recursiveHelper(TreeNode root, int k, Set<Integer> seen) {
        if (root == null) return false;

        if (seen.contains(k - root.val)) return true;
        seen.add(root.val);

        return recursiveHelper(root.left, k, seen) || recursiveHelper(root.right, k, seen);
    }
}
