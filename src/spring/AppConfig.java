package spring;

public class AppConfig {
    public PaymentService paymentService() {
        return new KakaoPayService(); // 또는 new CreditCardService();
    }

    public OrderService orderService() {
        return new OrderService(paymentService());
    }
}
