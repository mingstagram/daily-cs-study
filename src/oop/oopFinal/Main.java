package oop.oopFinal;

public class Main {
    public static void main(String[] args) {
        // 1. 전략 패턴처럼 알림 전략을 주입해서 실행
        Notifier emailNotifier = new EmailNotifier();
        NotificationContext emailContext = new NotificationContext(emailNotifier);
        emailContext.execute("주문이 완료되었습니다!");

        // 2. 템플릿 메서드 패턴으로 실행 흐름 고정 + 알림 방식만 변경
        AbstractNotificationService smsService = new AbstractNotificationService() {
            @Override
            protected Notifier createNotifier() {
                return new SmsNotifier();
            }
        };
        smsService.notifyUser("회원가입이 완료되었습니다.");
    }
}

interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("[이메일] " + message);
    }
}

class SmsNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("[SMS] " + message);
    }
}

// 템플릿 메서드 패턴 적용
abstract class AbstractNotificationService {
    public final void notifyUser(String message) {
        Notifier notifier = createNotifier();
        notifier.send(message);
        log(message);
    }

    protected abstract Notifier createNotifier();

    private void log(String msg) {
        System.out.println("알림 로그 저장: " + msg);
    }
}

// 팩토리 or 컨텍스트에서 분기 처리
class NotificationContext {
    private Notifier notifier;

    NotificationContext(Notifier notifier) {
        this.notifier = notifier;
    }

    void execute(String msg) {
        notifier.send(msg);
    }
}
