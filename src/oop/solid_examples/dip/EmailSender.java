package oop.solid_examples.dip;

/**
 * 이메일 전송 구현체
 */
public class EmailSender implements MessageSender {
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}
