package solid_examples.dip;

/**
 * 고수준 모듈이 인터페이스(MessageSender)에 의존하여 DIP를 만족하는 구조
 */
public class NotificationService {
    private final MessageSender sender;

    public NotificationService(MessageSender sender) {
        this.sender = sender;
    }

    public void notify(String message) {
        sender.send(message);
    }
}
