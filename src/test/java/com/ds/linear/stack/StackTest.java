package com.ds.linear.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackTest {

    @Test
    public void push() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(4);
        stack.push(5);
        stack.push(7);

        assertEquals(7, stack.peek());
    }

    @Test
    public void pop() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(4);
        stack.push(5);
        stack.push(7);

        stack.pop();
        assertEquals(5, stack.peek());

        stack.pop();
        assertEquals(4, stack.peek());
    }

}