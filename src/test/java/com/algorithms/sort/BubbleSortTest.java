package com.algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleSortTest {

    @Test
    public void TestCase1() {
        int[] expected = {2, 3, 5, 5, 6, 8, 9};
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        BubbleSort.bubbleSort(input);
        assertArrayEquals(expected, input);
    }

}