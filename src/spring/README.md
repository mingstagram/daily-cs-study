# 💡 IoC & DI 실습 예제

## 🎯 목적

이 프로젝트는 Spring 없이도 객체지향 설계 원칙 중 **IoC (제어의 역전)**과 **DI (의존성 주입)** 개념을 실습할 수 있도록 구성된 간단한 예제입니다.  
설정 파일 없이 **수동으로 객체를 조립**하면서 DI의 개념을 직접 체감할 수 있습니다.

---

## 📦 구조

```
src/
└── spring/
    ├── AppConfig.java           // 객체를 생성하고 조립하는 클래스 (수동 DI)
    ├── PaymentService.java      // 결제 서비스 인터페이스 (추상화)
    ├── KakaoPayService.java     // 결제 구현체 1
    ├── CreditCardService.java   // 결제 구현체 2
    ├── OrderService.java        // 결제 로직을 수행하는 서비스
    └── Main.java                // 실행 클래스
```

---

## 🧪 실행 흐름

1. `AppConfig`에서 `PaymentService` 구현체를 생성하고 `OrderService`에 주입합니다.
2. `Main` 클래스에서 `orderService.order(금액)`을 호출하면 결제가 실행됩니다.

---

## 🧩 주요 코드

### DI 적용 예시

```java
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
```

---

## 💬 실습 포인트

- **IoC**: 객체 생성과 관리를 개발자가 직접 하지 않고 AppConfig에 위임
- **DI**: `OrderService`가 `PaymentService`를 직접 생성하지 않고 생성자를 통해 주입받음
- **인터페이스 기반 설계**: `PaymentService` 인터페이스를 기반으로 유연한 구현 가능

---

## ✅ 출력 예시

```
주문 생성됨
카카오페이로 10000원 결제 완료
```

--- 
