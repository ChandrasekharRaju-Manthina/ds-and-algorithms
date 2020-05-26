package com.ds.linear.stack;

public class MinMaxStack {

    Stack stack = new Stack();
    Stack minStack = new Stack();
    Stack maxStack = new Stack();

    public int peek() {
        return stack.peek();
    }

    public int pop() {
        int item = stack.pop();

        if (item == minStack.peek()) {
            minStack.pop();
        }

        if (item == maxStack.peek()) {
            maxStack.pop();
        }

        return item;
    }

    public void push(Integer number) {
        stack.push(number);

        if (minStack.isEmpty() || number <= minStack.peek()) {
            minStack.push(number);
        }

        if (maxStack.isEmpty() || number >= maxStack.peek()) {
            maxStack.push(number);
        }
    }

    public int getMin() {
        return minStack.peek();
    }

    public int getMax() {
        return maxStack.peek();
    }
}
