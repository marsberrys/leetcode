package solutions.s211;

import base.TrieNode;
import org.junit.Assert;
import org.junit.Test;


/**
 * 211. 添加与搜索单词 - 数据结构设计
 * @Author weixun
 * @Date 2021-10-20
 * @See https://leetcode-cn.com/problems/design-add-and-search-words-data-structure/
 */
public class WordDictionary {

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        if(null == word || "".equals(word)) {
            return;
        }

        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
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

        return searchFromIndex(word, root, 0);
    }

    private boolean searchFromIndex(String word, TrieNode head, int from) {
        TrieNode cur = head;
        for(int i = from; i < word.length(); i++) {
            if('.' == word.charAt(i)) {
                for(TrieNode child : cur.children) {
                    if(child != null && searchFromIndex(word, child, i + 1)) {
                        return true;
                    }
                }

                return false;
            }

            int idx = word.charAt(i) - 'a';
            if(cur.children[idx] == null) {
                return false;
            }
            cur = cur.children[idx];
        }

        return cur.end;
    }

    @Test
    public void test() {

        WordDictionary trie = new WordDictionary();
        trie.addWord("bad");
        trie.addWord("dad");
        trie.addWord("mad");
        Assert.assertEquals(false, trie.search("pad"));
        Assert.assertEquals(true, trie.search("bad"));
        Assert.assertEquals(true, trie.search(".ad"));
        Assert.assertEquals(true, trie.search("b.."));

        System.out.println("ok");
    }
}
