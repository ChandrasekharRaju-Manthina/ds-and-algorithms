package com.ds.nonlinear.graph;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

    public static List<String> traverse(Node node) {
        List<String> items = new ArrayList<>();
        depthFirstSearch(node, items);
        return items;
    }

    private static void depthFirstSearch(Node node, List<String> array) {
        array.add(node.name);
        for(Node child:node.children ) {
            depthFirstSearch(child, array);
        }
    }

}
