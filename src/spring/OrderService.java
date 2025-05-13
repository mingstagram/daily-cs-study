package spring;

public class OrderService {
    private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void order(int amount) {
        System.out.println("주문 생성됨");
        paymentService.pay(amount);
    }
}
