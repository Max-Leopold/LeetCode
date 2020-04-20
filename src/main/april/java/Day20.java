package main.april.java;

import main.util.java.TreeNode;

public class Day20 {

	public static void main(String[] args) {
		Day20 day20 = new Day20();
		day20.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
	}

	public TreeNode bstFromPreorder(int[] preorder) {
		TreeNode root = new TreeNode(preorder[0]);

		for (int i = 1; i < preorder.length; i++) {
			addNode(root, preorder[i]);
		}

		return root;
	}

	public void addNode(TreeNode root, int val) {
		if (root.val < val) {
			if (root.right != null) {
				addNode(root.right, val);
			} else {
				root.right = new TreeNode(val);
			}
		} else {
			if (root.left != null) {
				addNode(root.left, val);
			} else {
				root.left = new TreeNode(val);
			}
		}
	}
}
