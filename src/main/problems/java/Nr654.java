package main.problems.java;

import main.util.java.TreeNode;

public class Nr654 {
    public static void main(String[] args) {
        Nr654 nr654 = new Nr654();
        TreeNode treeNode = nr654.constructMaximumBinaryTree(
                new int[]{3, 2, 1, 6, 0, 5}
        );
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (end < start) {
            return null;
        }
        TreeNode root = new TreeNode();
        int maximumElementIndex = getMaximumElementIndex(nums, start, end);
        root.val = nums[maximumElementIndex];
        root.left = constructMaximumBinaryTree(nums, start, maximumElementIndex - 1);
        root.right = constructMaximumBinaryTree(nums, maximumElementIndex + 1, end);
        return root;
    }

    private int getMaximumElementIndex(int[] nums, int start, int end) {
        int max = start;
        for (int i = start + 1; i <= end; i++) {
            max = nums[max] > nums[i] ? max : i;
        }
        return max;
    }
}
