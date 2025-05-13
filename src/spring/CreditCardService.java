package spring;

public class CreditCardService implements PaymentService{
    @Override
    public void pay(int amount) {
        System.out.println("신용카드로 " + amount + "원 결제 완료");
    }
}
