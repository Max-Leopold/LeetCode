package main.ctci.ch4.question2;

import main.util.java.BinaryTreeNode;

public class Solution1 {

    static BinaryTreeNode minimalTree(int[] sortedValues) {
        return buildMinimalTree(0, sortedValues.length - 1, sortedValues);
    }

    private static BinaryTreeNode buildMinimalTree(int start, int stop, int[] sortedValues) {
        if (stop < start) {
            return null;
        }

        if (start == stop) {
            return new BinaryTreeNode(sortedValues[start]);
        }

        int pivot = (start + stop) / 2;
        BinaryTreeNode currentNode = new BinaryTreeNode(sortedValues[pivot]);
        currentNode.setLeft(buildMinimalTree(start, pivot - 1, sortedValues));
        currentNode.setRight(buildMinimalTree(pivot + 1, stop, sortedValues));

        return currentNode;
    }
}
