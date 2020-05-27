package com.ds.nonlinear.tree;

public class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = this.root;

        for (char c : word.toCharArray()) {
            TrieNode node = currentNode.children.get(c);
            if (node == null) {
                node = new TrieNode();
                currentNode.children.put(c, node);
            }
            currentNode = node;
        }

        currentNode.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode currentNode = this.root;
        for (char c : word.toCharArray()) {
            currentNode = currentNode.children.get(c);
            if (currentNode == null) {
                break;
            }
        }

        return currentNode != null && currentNode.endOfWord;
    }

    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode root, String word, int index) {
        if (root == null) {
            return false;
        }

        if (index == word.length()) {
            root.endOfWord = false;

            return root.children.size() == 0;
        }

        TrieNode trieNode = root.children.get(word.charAt(index));
        boolean delete = delete(trieNode, word, index + 1);

        if (delete) {
            root.children.remove(word.charAt(index));
        }

        return root.children.size() == 0;
    }

}
