package com.algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SelectionSortTest {

    @Test
    public void test() {
        int[] expected = {2, 3, 5, 5, 6, 8, 9};
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        SelectionSort.sort(input);
        assertArrayEquals(expected, input);
    }

}