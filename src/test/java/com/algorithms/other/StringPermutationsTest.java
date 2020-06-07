package com.algorithms.other;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StringPermutationsTest {

    @Test
    public void test() {
        List<String> permuations = StringPermutations.getPermutations("abc");
        assertEquals(6, permuations.size());

        List<String> expectedPermuations = Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba");
        expectedPermuations.forEach(permutation -> assertTrue(permuations.contains(permutation)));
    }

}