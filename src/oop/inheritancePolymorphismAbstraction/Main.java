package oop.inheritancePolymorphismAbstraction;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.bark();
        dog.speak();

        Animal animal1 = new Dog();
        animal1.speak();

        Animal animal2 = new Cat();
        animal2.speak();
    }
}

class Animal {
    void speak() {
        System.out.println("소리낸다");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("멍멍!");
    }

    @Override
    void speak() {
        System.out.println("멍멍이 소리낸다.");
    }
}

class Cat extends Animal {
    void bark() {
        System.out.println("야옹!");
    }

    @Override
    void speak() {
        System.out.println("고양이 소리낸다.");
    }
}