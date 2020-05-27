package com.ds.linear.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        assertEquals(2, stack.pop());
        assertEquals(7, stack.pop());
        testMinMaxPeek(5, 5, 5, stack);
    }

    private void testMinMaxPeek(int min, int max, int peek, MinMaxStack stack) {
        assertEquals(stack.getMin(), min);
        assertEquals(stack.getMax(), max);
        assertEquals(stack.peek(), peek);
    }

}