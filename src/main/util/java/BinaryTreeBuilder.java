package main.util.java;

public class BinaryTreeBuilder {

    public static BinaryTreeNode insertLevelOrder(
            int[] arr,
            BinaryTreeNode root,
            int i,
            BinaryTreeNode parent) {
        if (i < arr.length) {
            BinaryTreeNode temp = new BinaryTreeNode(arr[i]);
            temp.setParent(parent);
            root = temp;

            root.setLeft(insertLevelOrder(arr, root.getLeft(), 2 * i + 1, temp));

            root.setRight(insertLevelOrder(arr, root.getRight(), 2 * i + 2, temp));
        }
        return root;
    }
}
