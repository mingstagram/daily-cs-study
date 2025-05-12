package oop.solid_examples.ocp;

/**
 * 이메일 전송 구현체 (OCP 적용)
 */
public class EmailSender implements NotificationSender {
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}
