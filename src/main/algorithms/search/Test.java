package main.algorithms.search;

public class Test {

    public static void main(String[] args) {
        int[] searchableArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(
                BinarySearch.search(searchableArray, 3)
        );
    }
}
