package oop.singletonFactory;

public class FactoryExample {
    public static void main(String[] args) {
        Product ap = ProductFactory.createProduct("A");
        ap.use();
        Product ap2 = ProductFactory.createProduct("B");
        ap2.use();
    }
}

interface Product {
    void use();
}

class AProduct implements Product {
    public void use() {
        System.out.println("AProduct 사용");
    }
}

class ProductFactory {
    public static Product createProduct(String type) {
        if (type.equals("A")) return new AProduct();
        throw new IllegalArgumentException("지원하지 않는 타입");
    }
}