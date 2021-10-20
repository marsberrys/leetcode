package solutions.s208;

import base.TreeNode;
import base.TrieNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 208. 实现 Trie (前缀树)
 * @Author weixun
 * @Date 2021-10-19
 * @See https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if(null == word || "".equals(word)) {
            return;
        }

        int len = word.length();
        char[] wordChars = word.toCharArray();
        TrieNode cur = root;
        for(int i = 0; i < len; i++) {
            int idx = wordChars[i] - 'a';
            if(cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        if(null == root || null == word || "".equals(word)) {
            return false;
        }
        int len = word.length();
        char[] wordChars = word.toCharArray();
        TrieNode cur = root;
        for(int i = 0; i < len; i++) {
            int idx = wordChars[i] - 'a';
            if(cur.children[idx] == null) {
                return false;
            }
            cur = cur.children[idx];
        }

        return cur.end;
    }

    public boolean startsWith(String prefix) {
        if(null == root || null == prefix || "".equals(prefix)) {
            return false;
        }
        int len = prefix.length();
        char[] wordChars = prefix.toCharArray();
        TrieNode cur = root;
        for(int i = 0; i < len; i++) {
            int idx = wordChars[i] - 'a';
            if(cur.children[idx] == null) {
                return false;
            }
            cur = cur.children[idx];
        }

        return true;
    }

    @Test
    public void test() {

        Trie trie = new Trie();
        trie.insert("apple");
        Assert.assertEquals(true, trie.search("apple"));
        Assert.assertEquals(false, trie.search("app"));
        Assert.assertEquals(true, trie.startsWith("app"));
        trie.insert("app");
        Assert.assertEquals(true, trie.search("app"));

        System.out.println("ok");
    }
}
