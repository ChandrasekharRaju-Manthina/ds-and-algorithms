package com.ds.linear.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private List<Integer> items;

    public Stack() {
        this.items = new ArrayList<>();
    }

    public int peek() {
        int item = -1;
        if (!items.isEmpty()) {
            item = items.get(items.size() - 1);
        }
        return item;
    }

    public int pop() {
        int item = -1;
        if (!items.isEmpty()) {
            item = items.remove(items.size() - 1);
        }
        return item;
    }

    public void push(Integer number) {
        items.add(number);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

}