package main.ctci.ch3.question6;

public class Main {

    public static void main(String[] args) {
        AnimalShelter animalShelter = new AnimalShelter();

        animalShelter.enqueue(new AnimalShelter.Cat("a"));
        animalShelter.enqueue(new AnimalShelter.Dog("b"));

        System.out.println(animalShelter.dequeAny());

        animalShelter.enqueue(new AnimalShelter.Dog("c"));
        animalShelter.enqueue(new AnimalShelter.Cat("d"));

        System.out.println(animalShelter.dequeueDog());
        System.out.println(animalShelter.dequeueCat());
        System.out.println(animalShelter.dequeAny());
    }
}
