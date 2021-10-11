package solutions.s187;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 187. 重复的DNA序列
 * @Author weixun
 * @Date 2021-10-08
 * @See https://leetcode-cn.com/problems/repeated-dna-sequences/
 */
public class Solution {

    private static final int L = 10;

    /**
     * 朴素实现
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if(null == s || "".equals(s) || s.length() < L) {
            return res;
        }

        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length() - L + 1; i++) {
            String sub = s.substring(i, i + L);
            if(countMap.getOrDefault(sub, 0) == 1) {
                res.add(sub);
            }
            countMap.put(sub, countMap.getOrDefault(sub, 0) + 1);
        }
        return res;
    }


    private static final Map<Character, Integer> char2Bin = new HashMap() {{
       put('A', 0);
       put('C', 1);
       put('G', 2);
       put('T', 3);
    }};

    /**
     * 位操作实现
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequencesBinary(String s) {
        List<String> res = new ArrayList<>();
        if(null == s || "".equals(s) || s.length() < L) {
            return res;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        int i = 0;
        int sub = 0;
        char[] sChars = s.toCharArray();
        for (; i < L - 1; i++) {
            sub = (sub << 2) | char2Bin.get(sChars[i]);
        }
        for (; i < s.length(); i++) {
            sub = ((sub << 2) | char2Bin.get(sChars[i])) & ((1 << (L * 2)) - 1);
            if(countMap.getOrDefault(sub, 0) == 1) {
                res.add(s.substring(i - L + 1, i + 1));
            }
            countMap.put(sub, countMap.getOrDefault(sub, 0) + 1);
        }
        return res;
    }

    @Test
    public void test() {

        assert Arrays.asList("AAAAACCCCC","CCCCCAAAAA").equals(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));

        assert Arrays.asList("AAAAAAAAAA").equals(findRepeatedDnaSequences("AAAAAAAAAAAAA"));

        assert Arrays.asList().equals(findRepeatedDnaSequences("AAAA"));

        assert Arrays.asList("AAAAACCCCC","CCCCCAAAAA").equals(findRepeatedDnaSequencesBinary("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));

        assert Arrays.asList("AAAAAAAAAA").equals(findRepeatedDnaSequencesBinary("AAAAAAAAAAAAA"));

        assert Arrays.asList().equals(findRepeatedDnaSequencesBinary("AAAA"));

        System.out.println("ok");
    }
}
