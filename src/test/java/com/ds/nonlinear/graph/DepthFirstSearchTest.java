package com.ds.nonlinear.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearchTest {

    @Test
    public void test() {
        Node graph = new Node("A");
        graph.addChild("B").addChild("C").addChild("D");
        graph.children.get(0).addChild("E").addChild("F");
        graph.children.get(2).addChild("G").addChild("H");
        graph.children.get(0).children.get(1).addChild("I").addChild("J");
        graph.children.get(2).children.get(0).addChild("K");
        String[] expected = {"A", "B", "E", "F", "I", "J", "C", "D", "G", "K", "H"};
        List<String> inputArray = new ArrayList<String>();
        Assert.assertEquals(DepthFirstSearch.traverse(graph).toArray(), expected);
    }

}