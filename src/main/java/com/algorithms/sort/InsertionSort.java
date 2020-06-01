package com.algorithms.sort;

public class InsertionSort {

    public static int[] sort(int[] array) {
        for(int i=1; i<array.length; i++) {
            for(int j=i; j>0; j--) {
                if(array[j] < array[j-1]) {
                    swap(array, j, j-1);
                }
            }
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
