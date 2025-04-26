package os;

import java.util.concurrent.locks.ReentrantLock;

public class MutexExample {
    private static int count = 0; // 공유 자원 (모든 스레드가 접근하려는 변수)
    private static ReentrantLock lock = new ReentrantLock(); // 뮤텍스 역살을 하는 Lock 객체 생성

    public static void main(String[] args) {
        // 각 스레드가 실행할 작업 정의
        Runnable task = () -> {
            lock.lock(); // 공유 자원(count) 접근 전에 락을 건다
            try {
                for (int i = 0; i < 1000; i++) {
                    count++; // count 값을 안전하게 1씩 증가시킨다
                }
            } finally {
                lock.unlock(); // 작업이 끝났으면 락을 반드시 해제한다
            }
        };

        // 두 개의 스레드 생성
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start(); // 첫 번째 스레드 시작
        t2.start(); // 두 번째 스레드 시작

        try {
            t1.join(); // t1 스레드가 끝날 때까지 기다림
            t2.join(); // t2 스레드가 끝날 때까지 기다림
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("최종 count: " + count); // 기대 출력: 2000 (1000 + 1000)

    }

}
