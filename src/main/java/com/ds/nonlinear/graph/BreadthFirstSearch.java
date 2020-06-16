package com.ds.nonlinear.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    // O(v+e) time | O(v) space
    public static List<String> traverse(Node root) {
        List<String> items = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            items.add(current.name);
            queue.addAll(current.children);
        }
        return items;
    }
}
