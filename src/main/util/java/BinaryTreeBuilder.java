package main.util.java;

public class BinaryTreeBuilder {

    public static BinaryTreeNode insertLevelOrder(int[] arr, BinaryTreeNode root, int i) {
        if (i < arr.length) {
            BinaryTreeNode temp = new BinaryTreeNode(arr[i]);
            root = temp;

            root.setLeft(insertLevelOrder(arr, root.getLeft(), 2 * i + 1));

            root.setRight(insertLevelOrder(arr, root.getRight(), 2 * i + 2));
        }
        return root;
    }
}
