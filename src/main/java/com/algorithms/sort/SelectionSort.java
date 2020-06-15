package com.algorithms.sort;

import java.util.*;

class SelectionSort {

    public static int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minElementIdx = getMin(array, i + 1);

            if (array[minElementIdx] < array[i]) {
                swap(array, i, minElementIdx);
            }
        }
        return array;
    }

    private static void swap(int[] array, int i, int minElementIdx) {
        int temp = array[minElementIdx];
        array[minElementIdx] = array[i];
        array[i] = temp;
    }

    private static int getMin(int[] array, int startIdx) {
        int min = startIdx;
        for (int i = startIdx + 1; i < array.length; i++) {
            if (array[i] < array[min]) {
                min = i;
            }
        }
        return min;
    }
}
