package datastructure.heapPriorityQueue;

import java.util.PriorityQueue;

public class MinHeapExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(20);
        minHeap.add(5);
        minHeap.add(15);

        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }

    }
}
