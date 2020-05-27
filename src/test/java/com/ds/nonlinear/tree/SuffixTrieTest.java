package com.ds.nonlinear.tree;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SuffixTrieTest {

    @Test
    public void isValidSuffix() {
        SuffixTrie trie = new SuffixTrie("babc");
        assertTrue(trie.contains("abc"));
    }

}