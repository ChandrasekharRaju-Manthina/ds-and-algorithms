package com.ds.nonlinear.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {

    String name;
    List<Node> children = new ArrayList<>();

    public Node(String name) {
        this.name = name;
    }

    public Node addChild(String name) {
        Node child = new Node(name);
        children.add(child);
        return this;
    }

}
