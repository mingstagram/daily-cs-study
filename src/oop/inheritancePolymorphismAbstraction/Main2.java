package oop.inheritancePolymorphismAbstraction;

public class Main2 {
    public static void main(String[] args) {
        Circle c = new Circle(3);
        System.out.println(c.area()); // 28.274333882308138
    }
}

abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    double radius;
    Circle(double r) {
        radius = r;
    }
    double area() {
        return Math.PI * radius * radius;
    }
}
