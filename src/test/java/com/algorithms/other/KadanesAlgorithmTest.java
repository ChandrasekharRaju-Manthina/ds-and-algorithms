package com.algorithms.other;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KadanesAlgorithmTest {

    @Test
    public void maxSubArraySum() {
        final int[] array = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 5, 6, 3, 1, -5, 4};
        final int maxSubArraySum = KadanesAlgorithm.maxSubArraySum(array);
        assertEquals(24, maxSubArraySum);
    }
}