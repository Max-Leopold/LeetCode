package main.ctci.ch4.question3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import main.util.java.BinaryTreeBuilder;
import main.util.java.BinaryTreeNode;

public class Main {

    public static void main(String[] args) {
        System.out.println(
                Arrays.deepToString(
                        Solution1.listOfDepths(
                                BinaryTreeBuilder.insertLevelOrder(
                                        new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},
                                        new BinaryTreeNode(1),
                                        0,
                                        null)
                        )
                                .stream()
                                .map(List::toArray).collect(Collectors.toList())
                                .toArray()
                )
        );
    }
}
