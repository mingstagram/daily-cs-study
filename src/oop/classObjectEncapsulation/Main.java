package oop.classObjectEncapsulation;

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car(); // 객체 생성
        myCar.model = "Avante"; // 필드 설정
        myCar.accelerate(); // 메서드 실행

        BankAccount account = new BankAccount();
        account.deposit(2000);
        System.out.println(account.getBalance());
        account.deposit(2000);
        System.out.println(account.getBalance());

    }
}
