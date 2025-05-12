package oop.strategyTemplateObserver;

public class StrategyPattern {
    public static void main(String[] args) {

        PaymentProcessor kakao = new PaymentProcessor(new KakaoPay());
        kakao.process(4000);

        PaymentProcessor naver = new PaymentProcessor(new NaverPay());
        naver.process(2000);

    }
}

interface PaymentStrategy {
    void pay(int amount);
}

class KakaoPay implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("카카오페이로 " + amount + "원 결제");
    }
}

class NaverPay implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("네이버페이로 " + amount + "원 결제");
    }
}

class PaymentProcessor {
    private PaymentStrategy strategy;
    public PaymentProcessor(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    public void process(int amount){
        strategy.pay(amount);
    }
}