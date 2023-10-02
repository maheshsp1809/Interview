import java.util.*;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[maxSize + 1];
        heap[0] = Integer.MAX_VALUE; // Set a sentinel value at the root
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return 2 * pos;
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        return pos >= (size / 2) && pos <= size;
    }

    private void swap(int fpos, int spos) {
        int temp;
        temp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = temp;
    }

    private void maxHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]) {
                if (heap[leftChild(pos)] > heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int element) {
        if (size >= maxSize) {
            return;
        }
        heap[++size] = element;
        int current = size;

        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void buildHeap(int[] arr) {
        if (arr.length > maxSize) {
            return; // Not enough space in the heap
        }

        size = arr.length;
        System.arraycopy(arr, 0, heap, 1, size);

        for (int i = size / 2; i >= 1; i--) {
            maxHeapify(i);
        }
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print("Parent: " + heap[i] + " Left Child: " + heap[2 * i]);
            if (2 * i + 1 <= size) {
                System.out.print(" Right Child: " + heap[2 * i + 1]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(15);
        int[] arr = { 3, 10, 8, 5, 7, 12, 4, 2, 11 };

        maxHeap.buildHeap(arr);
        maxHeap.print();
    }
}
