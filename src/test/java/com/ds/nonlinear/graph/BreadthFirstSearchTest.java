package com.ds.nonlinear.graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class BreadthFirstSearchTest {

    @Test
    public void test() {
        Node graph = new Node("A");
        graph.addChild("B").addChild("C").addChild("D");
        graph.children.get(0).addChild("E").addChild("F");
        graph.children.get(2).addChild("G").addChild("H");
        graph.children.get(0).children.get(1).addChild("I").addChild("J");
        graph.children.get(2).children.get(0).addChild("K");
        String[] expected = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
        assertEquals(BreadthFirstSearch.traverse(graph).toArray(), expected);
    }
}