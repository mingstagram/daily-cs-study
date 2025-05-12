package oop.solid_examples.srp;

/**
 * 사용자 정보를 출력하는 책임만 가짐 (단일 책임 원칙)
 */
public class UserPrinter {
    public void printUser(User user) {
        System.out.println("User: " + user.getName() + ", Email: " + user.getEmail());
    }
}
