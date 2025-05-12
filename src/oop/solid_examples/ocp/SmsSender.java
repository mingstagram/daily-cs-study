package oop.solid_examples.ocp;

/**
 * SMS 전송 구현체 (OCP 적용)
 */
public class SmsSender implements NotificationSender {
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}
