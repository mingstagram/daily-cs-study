package oop.solid_examples.lsp;

/**
 * 타조는 날 수 없지만 Bird를 상속받아 fly()를 오버라이드하면서 예외를 발생시킴
 * → 리스코프 치환 원칙 위반 예제
 */
public class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostrich can't fly");
    }
}
