package main.util.java;


public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return "TreeNode{" +
				"val=" + val +
				", left=" + left +
				", right=" + right +
				'}';
	}
}
