package main.ctci.ch4.question3;

import java.util.ArrayList;
import java.util.List;

import main.util.java.BinaryTreeNode;

public class Solution1 {

    static List<List<BinaryTreeNode>> listOfDepths(BinaryTreeNode root) {
        return createLists(root, new ArrayList<>(), 0);
    }

    private static List<List<BinaryTreeNode>> createLists(
            BinaryTreeNode root,
            List<List<BinaryTreeNode>> listOfDepths,
            int depth
    ) {
        if (root == null) {
            return listOfDepths;
        }
        if (depth >= listOfDepths.size()) {
            listOfDepths.add(new ArrayList<>());
        }
        listOfDepths.get(depth).add(root);
        createLists(root.getLeft(), listOfDepths, depth + 1);
        createLists(root.getRight(), listOfDepths, depth + 1);
        return listOfDepths;
    }
}
