package datastructure.stackQueueDeque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class StackQueueDequeDemo {
    public static void main(String[] args) {
        // 스택
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        System.out.println("Stack pop: " + stack.pop());

        // 큐
        Queue<String> queue = new LinkedList<>();
        queue.offer("A");
        queue.offer("B");
        System.out.println("Queue poll: " + queue.poll());

        // 덱
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("X");
        deque.addLast("Y");
        System.out.println("Deque pollLast: " + deque.pollLast());
    }

}
