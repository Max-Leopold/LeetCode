package main.ctci.ch3.question2;

public class Main {

    public static void main(String[] args) {
        StackMin<Integer> stackMin = new StackMin<>();
        stackMin.push(1);
        stackMin.push(2);
        stackMin.push(8);
        stackMin.push(-1);
        stackMin.push(-1);

        System.out.println(stackMin.min());
        stackMin.pop();
        System.out.println(stackMin.min());
        stackMin.pop();
        System.out.println(stackMin.min());

    }
}
