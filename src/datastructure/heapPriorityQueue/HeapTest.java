package datastructure.heapPriorityQueue;

import java.util.*;

public class HeapTest {
    public static void main(String[] args) {
        MinHeap heap = new MinHeap(); // 최소 힙 생성

        // 테스트할 값들
        int[] values = {30, 10, 20, 50, 5};

        // 값을 하나씩 힙에 넣으면서, 최소값 출력
        for (int v : values) {
            heap.add(v);
            System.out.println("추가 후 최소값: " + heap.peek());; // 항상 루트가 최소값
        }

        // 힙에서 값을 하나씩 꺼내면서 출력 (자동으로 최소값부터 꺼내짐)
        System.out.println("\nMinHeap에서 값 꺼내기:");
        while (!heap.isEmpty()) {
            System.out.println(heap.poll()); // poll()은 최소값을 꺼내고 힙을 재정렬
        }
    }
}

class MinHeap {
    // 내부적으로 힙을 저장할 리스트 (배열처럼 사용)
    private List<Integer> heap = new ArrayList<>();


    // 값 추가 (힙에 삽입할 때는 마지막에 추가 후 위로 올라가며 정렬)
    void add(int val) {
        heap.add(val); // 일단 끝에 값 추가
        int i = heap.size() - 1; // 방금 추가한 값의 인덱스

        // 부모 노드와 비교하며 위로 올라가기 (heapify up)
        while (i > 0) {
            int parent = (i - 1) / 2; // 부모 인덱스 구하기
            if (heap.get(i) >= heap.get(parent)) break; // 부모보다 크거나 같으면 멈춤
            Collections.swap(heap, i, parent); // 현재 노드와 부모를 교체
            i = parent; // 부모 위치로 이동해 다시 검사
        }
    }

    // 최소값 꺼내기 (루트를 제거하고 아래로 정렬)
    int poll() {
        if (heap.isEmpty()) throw new NoSuchElementException();

        int root = heap.get(0); // 항상 최소값은 루트(0번 인덱스)
        int last = heap.remove(heap.size() - 1); // 마지막 값을 제거하고

        // 루트에 마지막 값을 넣고, heapify down 진행
        if (!heap.isEmpty()) heap.set(0, last);

        int i = 0;
        while (i < heap.size()) {
            int left = 2 * i + 1; // 왼쪽 자식 인덱스
            int right = 2 * i + 2; // 오른쪽 자식 인덱스
            int smallest = i; // 가장 작은 값의 인덱스를 현재로 초기화

            // 왼쪽 자식이 더 작으면 교체 후보
            if (left < heap.size() && heap.get(left) < heap.get(smallest)) smallest = left;

            // 오른족 자식이 더 작으면 교체 후보 갱신
            if (right < heap.size() && heap.get(right) < heap.get(smallest)) smallest = right;

            // 부모가 자식보다 작거나 같으면 정렬 완료
            if (smallest == i) break;

            // 자식 중 더 작은 값과 교체 (heapify down)
            Collections.swap(heap, i, smallest);
            i = smallest; // 자식으로 내려가서 다시 검사
        }

        return root; // 제거된 최소값 반환
    }

    // 최솟값 확인 (제거하지 않음)
    public int peek() {
        if (heap.isEmpty()) throw new NoSuchElementException();
        return heap.get(0); // 루트는 항상 최소값
    }

    // 비었는지 확인
    public boolean isEmpty() {
        return heap.isEmpty();
    }

}