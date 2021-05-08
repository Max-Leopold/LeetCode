package main.problems.java;

import java.util.ArrayList;
import java.util.List;

import main.util.java.TreeNode;

public class Nr102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        return createLevels(root, new ArrayList<>(), 0);
    }

    private List<List<Integer>> createLevels(TreeNode root, List<List<Integer>> levels, int depth) {
        if (root == null) {
            return levels;
        }
        if (levels.size() - 1 < depth) {
            levels.add(new ArrayList<>());
        }
        levels.get(depth).add(root.val);
        createLevels(root.left, levels, depth + 1);
        createLevels(root.right, levels, depth + 1);
        return levels;
    }
}
