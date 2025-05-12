package oop.singletonFactory;

public class SingletonExample {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }
}

class Singleton {
    private static final Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }
}