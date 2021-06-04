package main.problems.java;

import main.util.java.TreeNode;

public class Nr979 {

    private static int moves;

    public int distributeCoins(TreeNode root) {
        moves = 0;
        dfs(root);
        return moves;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = dfs(root.left);
        int R = dfs(root.right);
        moves += Math.abs(L) + Math.abs(R);
        return L + R + root.val - 1;
    }
}
