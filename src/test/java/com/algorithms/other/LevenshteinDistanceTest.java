package com.algorithms.other;

import com.algorithms.sort.InsertionSort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class LevenshteinDistanceTest {

    @Test
    public void editDistance() {
        int editDistance = LevenshteinDistance.editDistance("biting", "mitten");
        assertEquals(4, editDistance);
    }

}