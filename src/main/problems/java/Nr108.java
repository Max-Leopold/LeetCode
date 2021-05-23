package main.problems.java;

import main.util.java.TreeNode;

public class Nr108 {
    public static void main(String[] args) {
        Nr108 nr108 = new Nr108();
        TreeNode root = nr108.sortedArrayToBST(
                new int[]{-10, -3, 0, 5, 9}
        );
        System.out.println(root);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length - 1);
    }

    public TreeNode createBST(int[] nums, int start, int end) {
        if (end < start) return null;
        if (end == start) return new TreeNode(nums[start]);
        int index = (start + end) / 2;
        TreeNode root = new TreeNode(nums[index]);
        root.left = createBST(nums, start, index - 1);
        root.right = createBST(nums, index + 1, end);
        return root;
    }
}
