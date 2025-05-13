package spring;

public class Main {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();

        OrderService orderService = config.orderService();
        orderService.order(10000);
    }
}
