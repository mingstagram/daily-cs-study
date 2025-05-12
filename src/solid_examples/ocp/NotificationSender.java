package solid_examples.ocp;

/**
 * 알림 전송을 위한 인터페이스 (확장을 위한 추상화)
 */
public interface NotificationSender {
    void send(String message);
}
