package main.april.java;


import main.util.java.TreeNode;

public class Day11 {

	int diameter = 1;

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		getDiameter(root);
		return diameter;
	}

	public int getDiameter(TreeNode root) {
		int longestLeft = root.left != null ? getDiameter(root.left) : 0;
		int longestRight = root.right != null ? getDiameter(root.right) : 0;

		diameter = Math.max(diameter, longestLeft + longestRight + 1);
		return Math.max(longestLeft, longestRight) + 1;
	}
}
