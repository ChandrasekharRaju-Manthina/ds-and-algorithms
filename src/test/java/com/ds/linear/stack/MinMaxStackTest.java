package com.ds.linear.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinMaxStackTest {

    @Test
    public void test() {
        MinMaxStack stack = new MinMaxStack();
        stack.push(5);
        testMinMaxPeek(5, 5, 5, stack);
        stack.push(7);
        testMinMaxPeek(5, 7, 7, stack);
        stack.push(2);
        testMinMaxPeek(2, 7, 2, stack);
        assertTrue(stack.pop() == 2);
        assertTrue(stack.pop() == 7);
        testMinMaxPeek(5, 5, 5, stack);
    }

    public void testMinMaxPeek(int min, int max, int peek, MinMaxStack stack) {
        assertTrue(stack.getMin() == min);
        assertTrue(stack.getMax() == max);
        assertTrue(stack.peek() == peek);
    }

}