package spring;

public class KakaoPayService implements PaymentService {
    @Override
    public void pay(int amount) {
        System.out.println("카카오페이로 " + amount + "원 결제 완료");
    }
}
