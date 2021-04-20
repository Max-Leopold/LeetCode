package main.ctci.ch3.question4;

public class Main {

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        MyQueue2<Integer> queue2 = new MyQueue2<>();
        queue2.add(1);
        queue2.add(2);
        queue2.add(3);

        System.out.println(queue2.peek());
        System.out.println(queue2.remove());
        System.out.println(queue2.remove());
        System.out.println(queue2.remove());
    }
}
