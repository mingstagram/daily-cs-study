package datastructure.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceTest {

    private static final int TEST_SIZE = 100_000;

    public static void main(String[] args) {
        System.out.println("리스트 삽입 성능 테스트");

        testAddPerformance(new ArrayList<>(), "ArrayList - 맨 앞 삽입");
        testAddPerformance(new LinkedList<>(), "LinkedList - 맨 앞 삽입");

        System.out.println(" 리스트 조회 성능 테스트");

        testGetPerformance(new ArrayList<>(), "ArrayList - 인덱스 순회 조회");
        testGetPerformance(new LinkedList<>(), "LinkedList - 인덱스 순회 조회");
    }

    private static void testAddPerformance(List<Integer> list, String label) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < TEST_SIZE; i++) {
            list.add(0, i);
        }

        long end = System.currentTimeMillis();
        System.out.printf("%s → 소요 시간: %dms\n", label, (end - start));

    }

    private static void testGetPerformance(List<Integer> list, String label) {
        // 미리 데이터 채워두기
        for (int i = 0; i < TEST_SIZE; i++) {
            list.add(i);
        }

        long start = System.currentTimeMillis();

        for (int i = 0; i < TEST_SIZE; i++) {
            int val = list.get(i); // 순차 조회
        }

        long end = System.currentTimeMillis();
        System.out.printf("%s → 소요 시간: %dms\n", label, (end - start));

    }

}
