package main.problems.java;

import main.util.java.TreeNode;

public class Nr1315 {
	public int sumEvenGrandparent(TreeNode root) {
		return grandParentsSum(root, false, false);
	}

	public int grandParentsSum(TreeNode node, boolean parentIsEven, boolean grandParentIsEven) {
		if (node == null) {
			return 0;
		}

		int ownSum = grandParentIsEven ? node.val : 0;
		boolean isEven = node.val % 2 == 0;

		return grandParentsSum(node.left, isEven, parentIsEven) +
				grandParentsSum(node.right, isEven, parentIsEven)
				+ ownSum;
	}
}
