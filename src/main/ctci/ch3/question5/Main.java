package main.ctci.ch3.question5;

public class Main {

    public static void main(String[] args) {
        StackWithSort<Integer> stackWithSort = new StackWithSort<>();

        stackWithSort.push(10);
        stackWithSort.push(8);
        stackWithSort.push(1);
        stackWithSort.push(100);
        stackWithSort.push(8);
        stackWithSort.push(19);

        System.out.println(stackWithSort);

        stackWithSort.sortStack();

        System.out.println(stackWithSort);
    }
}
