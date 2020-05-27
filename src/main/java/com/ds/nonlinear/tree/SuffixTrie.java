package com.ds.nonlinear.tree;

public class SuffixTrie {

    TrieNode root = new TrieNode();
    char endSymbol = '*';

    public SuffixTrie(String str) {
        populateSuffixTrieFrom(str);
    }

    public void populateSuffixTrieFrom(String str) {
        for (int i = 0; i < str.length(); i++) {
            insert(str.substring(i, str.length()));
        }
    }

    public void insert(String suffix) {
        TrieNode currentNode = root;
        for (char c : suffix.toCharArray()) {
            TrieNode node = currentNode.children.get(c);
            if (node == null) {
                node = new TrieNode();
                currentNode.children.put(c, node);
            }
            currentNode = node;
        }

        currentNode.children.put(endSymbol, null);
    }

    public boolean contains(String str) {
        TrieNode currentNode = root;
        for (char c : str.toCharArray()) {
            currentNode = currentNode.children.get(c);
            if (currentNode == null) {
                break;
            }
        }

        return currentNode != null && currentNode.children.containsKey('*');
    }
}