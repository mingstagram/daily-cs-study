package oop.solid_examples.isp;

/**
 * 출력 기능만 제공하는 구현체
 */
public class BasicPrinter implements Printer {
    public void print() {
        System.out.println("Printing document...");
    }
}
