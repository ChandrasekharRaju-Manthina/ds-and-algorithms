package com.ds.nonlinear.heap;

import java.util.List;

public class MinHeap {
    List<Integer> heap;

    public MinHeap(List<Integer> array) {
        heap = buildHeap(array);
    }

    // O(n) time | O(1) space
    public List<Integer> buildHeap(List<Integer> array) {
        int firstParentIndex = (array.size() - 2) / 2;
        for (int i = firstParentIndex; i >= 0; i--) {
            siftDown(i, array.size() - 1, array);
        }
        return array;
    }

    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
        while (2 * currentIdx + 1 <= endIdx) {
            int left = 2 * currentIdx + 1;
            int right = 2 * currentIdx + 2;

            int min = right > endIdx ? left : (heap.get(left) < heap.get(right) ? left : right);

            if (heap.get(currentIdx) > heap.get(min)) {
                swap(heap, currentIdx, min);
                currentIdx = min;
            } else {
                break;
            }
        }
    }

    public void siftUp(int currentIdx, List<Integer> heap) {
        for (int i = currentIdx; i >= 0; i = (i - 1) / 2) {
            int parent = (i - 1) / 2;
            if (heap.get(i) < heap.get(parent)) {
                swap(heap, i, parent);
            } else {
                break;
            }
        }
    }

    private static void swap(List<Integer> list, int i, int j) {
        int temp = list.get(j);
        list.set(j, list.get(i));
        list.set(i, temp);
    }

    public int peek() {
        return heap.get(0);
    }

    // O(nlog(n)) time | O(1) space
    public int remove() {
        int min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        siftDown(0, heap.size() - 1, heap);
        return min;
    }

    // O(nlog(n)) time | O(1) space
    public void insert(int value) {
        heap.add(value);
        siftUp(heap.size() - 1, heap);
    }
}