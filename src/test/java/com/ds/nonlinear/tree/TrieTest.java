package com.ds.nonlinear.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {

    @Test
    public void insert() {
        Trie trie = new Trie();
        trie.insert("MANY");
        trie.insert("MATT");
        trie.insert("MATT");
        trie.insert("APPLE");

        assertTrue(trie.search("MANY"));
        assertTrue(trie.search("MATT"));
        assertFalse(trie.search("RAJU"));
    }

    @Test
    public void delete() {
        Trie trie = new Trie();
        trie.insert("MANY");
        trie.insert("MATT");
        trie.delete("MANY");

        assertTrue(trie.search("MATT"));
        assertFalse(trie.search("MANY"));
        assertTrue(trie.search("MATT"));
    }

}