package com.ds.nonlinear.tree;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;

    TrieNode() {
        this.children = new HashMap<>();
    }

}