package oop.strategyTemplateObserver;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public static void main(String[] args) {
        NotificationCenter center = new NotificationCenter();

        // 옵저버 등록
        Observer email = new EmailNotifier();
        Observer sms = new SmsNotifier();

        center.subscribe(email);
        center.subscribe(sms);

        // 이벤트 발생 -> 모든 옵저버에게 알림 전파
        center.notifyAllObservers("회원가입이 완료되었습니다.");
    }
}

interface Observer {
    void update(String msg);
}

class EmailNotifier implements Observer {
    public void update(String msg) {
        System.out.println("이메일 알림: " + msg);
    }
}

class SmsNotifier implements Observer {
    public void update(String msg) {
        System.out.println("SMS 알림: " + msg);
    }
}

class NotificationCenter {
    private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer o) {
        observers.add(o);
    }

    public void notifyAllObservers(String msg) {
        for (Observer o : observers) {
            o.update(msg);
        }
    }
}
