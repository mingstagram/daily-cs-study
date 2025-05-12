package datastructure.sort;

import java.util.*;

public class SortAlgorithmsTest {

    public static void main(String[] args) {
        int[] original = {5, 3, 8, 4, 2, 7, 1, 6};

        test("Bubble Sort", original.clone(), SortAlgorithmsTest::bubbleSort);
        test("Selection Sort", original.clone(), SortAlgorithmsTest::selectionSort);
        test("Insertion Sort", original.clone(), SortAlgorithmsTest::insertionSort);
        test("Quick Sort", original.clone(), arr -> quickSort(arr, 0, arr.length - 1));
        test("Merge Sort", original.clone(), arr -> mergeSort(arr, 0, arr.length - 1));
        test("Heap Sort", original.clone(), SortAlgorithmsTest::heapSort);
    }

    static void test(String name, int[] arr, java.util.function.Consumer<int[]> sortMethod) {
        sortMethod.accept(arr);
        System.out.print(name + ": ");
        for (int n : arr) System.out.print(n + " ");
        System.out.println();
    }

    // 버블 정렬
    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - 1 - i; j++)
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = tmp;
                }
    }

    // 선택 정렬
    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[minIdx]) minIdx = j;
            int tmp = arr[i]; arr[i] = arr[minIdx]; arr[minIdx] = tmp;
        }
    }

    // 삽입 정렬
    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i], j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; j--;
            }
            arr[j + 1] = key;
        }
    }

    // 퀵 정렬
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++)
            if (arr[j] < pivot) {
                i++;
                int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
            }
        int tmp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = tmp;
        return i + 1;
    }

    // 병합 정렬
    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right)
            tmp[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= right) tmp[k++] = arr[j++];
        for (int x = 0; x < tmp.length; x++) arr[left + x] = tmp[x];
    }

    // 힙 정렬 (PriorityQueue 활용)
    static void heapSort(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : arr) pq.add(n);
        for (int i = 0; i < arr.length; i++) arr[i] = pq.poll();
    }
}
