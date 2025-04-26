package os;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    static Semaphore parkingLot = new Semaphore(3); // 동시에 3대 주차할 수 있는 주차장 (세마포어 3칸)

    public static void main(String[] args) {
        // 차량 5대가 주차 시도
        for (int i = 1; i <= 5; i++) {
            final int carNum = i; // 차량 번호를 지역 변수로 저장
            new Thread(() -> {
                try {
                    System.out.println("차량 " + carNum + " 주차 대기 중");
                    parkingLot.acquire(); // 주차장 자리가 비어 있는지 확인하고, 자리를 차지한다
                    System.out.println("차랑 " + carNum + " 주차 성공");
                    Thread.sleep(2000); // 주차한 채로 2초 대기
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("차량 " + carNum + " 주차 끝, 출차");
                    parkingLot.release(); // 주차 공간 반납 (다른 차가 들어올 수 있게 함)
                }
            }).start();
        }
    }
}
