package main.problems.java;

import main.util.java.TreeNode;

public class Nr1038 {
    public static void main(String[] args) {
        Nr1038 nr1038 = new Nr1038();
        TreeNode root = new TreeNode(4);
        TreeNode zero = new TreeNode(0);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);

        root.left = one;
        root.right = six;

        one.left = zero;
        one.right = two;

        two.right = three;

        six.right = seven;
        six.left = five;

        seven.right = eight;


        System.out.println(nr1038.bstToGst(root));
    }

    public TreeNode bstToGst(TreeNode root) {
        getSum(root, 0);
        return root;
    }

    public int getSum(TreeNode root, int sumOfBiggerElements) {
        if (root == null) {
            return sumOfBiggerElements;
        }
        // right subtree
        // root
        // left subtree
        int sumRight = getSum(root.right, sumOfBiggerElements);
        root.val += sumRight;
        int sumLeft = getSum(root.left, root.val);
        return sumLeft;
    }
}
