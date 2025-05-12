package oop.solid_examples.srp;

/**
 * 사용자 정보를 저장하는 클래스 (데이터 책임만 가짐)
 */
public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
}
