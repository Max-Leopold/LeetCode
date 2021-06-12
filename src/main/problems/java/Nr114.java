package main.problems.java;

import main.util.java.TreeNode;

public class Nr114 {

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode threeTwo = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode fourTwo = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

        one.left = two;
        one.right = five;

        two.left = three;
        two.right = four;

        five.right = six;

        three.left = threeTwo;
        four.right = fourTwo;

        Nr114 nr114 = new Nr114();
        nr114.flatten(one);
        System.out.println(one);
    }

    public void flatten(TreeNode root) {
        flattenRec(root, null);
    }

    public TreeNode flattenRec(TreeNode root, TreeNode lastRight) {
        if (root == null) {
            return null;
        }

        TreeNode nextRight = flattenRec(root.right, lastRight);
        TreeNode nextLeft = flattenRec(root.left, nextRight == null ? lastRight : nextRight);

        if (nextLeft != null) {
            root.right = nextLeft;
            root.left = null;
            return root;
        }
        if (lastRight != null && nextRight == null) {
            root.right = lastRight;
            return root;
        }

        return root;
    }
}
