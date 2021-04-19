package main.ctci.ch3.question3;

public class Main {

    public static void main(String[] args) {
        StackOfPlates<Integer> stackOfPlates = new StackOfPlates<>(3);

        stackOfPlates.push(1);
        stackOfPlates.push(2);
        stackOfPlates.push(3);
        stackOfPlates.push(4);
        stackOfPlates.push(5);
        stackOfPlates.push(6);
        stackOfPlates.push(7);
        stackOfPlates.push(8);
        stackOfPlates.push(9);

        stackOfPlates.pop();
        stackOfPlates.pop();
        stackOfPlates.pop();

        stackOfPlates.push(7);

        stackOfPlates.popAtIndex(0);
        stackOfPlates.push(13);
        stackOfPlates.push(8);

        System.out.println(stackOfPlates);
    }
}
