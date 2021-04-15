package main.ctci.ch2.question6;

import main.util.java.ListNodeBuilder;

public class Main {

    public static void main(String[] args) {
        System.out.println((Solution1.isPalindrome(
                ListNodeBuilder.buildList(new int[]{6, 1, 7})
        )));

        System.out.println((Solution1.isPalindrome(
                ListNodeBuilder.buildList(new int[]{6, 1, 6})
        )));

        System.out.println((Solution1.isPalindrome(
                ListNodeBuilder.buildList(new int[]{6, 1, 6, 6})
        )));

        System.out.println((Solution1.isPalindrome(
                ListNodeBuilder.buildList(new int[]{6, 1, 1, 6})
        )));

        System.out.println((Solution1.isPalindrome(
                ListNodeBuilder.buildList(new int[]{6})
        )));

        System.out.println("---------");

        System.out.println((Solution2.isPalindrome(
                ListNodeBuilder.buildList(new int[]{6, 1, 7})
        )));

        System.out.println((Solution2.isPalindrome(
                ListNodeBuilder.buildList(new int[]{6, 1, 6})
        )));

        System.out.println((Solution2.isPalindrome(
                ListNodeBuilder.buildList(new int[]{6, 1, 6, 6})
        )));

        System.out.println((Solution2.isPalindrome(
                ListNodeBuilder.buildList(new int[]{6, 1, 1, 6})
        )));

        System.out.println((Solution2.isPalindrome(
                ListNodeBuilder.buildList(new int[]{6})
        )));

        System.out.println("---------");

        System.out.println((Solution3.isPalindrome(
                ListNodeBuilder.buildList(new int[]{6, 1, 7})
        )));

        System.out.println((Solution3.isPalindrome(
                ListNodeBuilder.buildList(new int[]{6, 1, 6})
        )));

        System.out.println((Solution3.isPalindrome(
                ListNodeBuilder.buildList(new int[]{6, 1, 6, 6})
        )));

        System.out.println((Solution3.isPalindrome(
                ListNodeBuilder.buildList(new int[]{6, 1, 1, 6})
        )));

        System.out.println((Solution3.isPalindrome(
                ListNodeBuilder.buildList(new int[]{6})
        )));
    }
}
