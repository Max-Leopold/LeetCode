package main.ctci.ch3.question6;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {

    private final Queue<Dog> dogQueue;
    private final Queue<Cat> catQueue;
    private int date;

    public AnimalShelter() {
        this.dogQueue = new LinkedList<>();
        this.catQueue = new LinkedList<>();
    }

    public void enqueue(Animal animal) {
        if (animal instanceof Cat) {
            animal.setDate(date);
            date++;
            catQueue.add((Cat) animal);
            return;
        }
        if (animal instanceof Dog) {
            animal.setDate(date);
            date++;
            dogQueue.add((Dog) animal);
            return;
        }

        throw new IllegalArgumentException("We do not have this kind of animal in our shelter, sorry.");
    }

    public Animal dequeAny() {
        if (catQueue.isEmpty()) {
            return dogQueue.remove();
        }
        if (dogQueue.isEmpty()) {
            return catQueue.remove();
        }

        if (catQueue.peek().getDate() < dogQueue.peek().getDate()) {
            return catQueue.remove();
        }
        return dogQueue.remove();
    }

    public Dog dequeueDog() {
        return dogQueue.remove();
    }

    public Cat dequeueCat() {
        return catQueue.remove();
    }

    public abstract static class Animal {
        protected final String name;
        private int date;

        public Animal(String name) {
            this.name = name;
        }

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }
    }

    public static class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
