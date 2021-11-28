package solutions.s438;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * @Author weixun
 * @Date 2021-11-28
 * @See https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        int[] chars = new int[26];

        List<Integer> ans = new ArrayList<>();
        int sLen = s.length(), pLen = p.length();
        int diff = pLen;
        for(int i = 0; i < pLen; i++) {
            chars[p.charAt(i) - 'a']++;
        }

        for(int i = 0; i < sLen; i++) {
            int idx = s.charAt(i) - 'a';
            chars[idx]--;
            if(chars[idx] >= 0) {
                diff--;
            } else {
                diff++;
            }
            if(i >= pLen) {
                int rIdx = s.charAt(i - pLen) - 'a';
                chars[rIdx]++;
                if(chars[rIdx] <= 0) {
                    diff--;
                } else {
                    diff++;
                }
            }
            if(i >= pLen - 1 && diff == 0) {
                ans.add(i - pLen + 1);
            }
        }

        return ans;
    }


    @Test
    public void test() {

        assert Arrays.asList(1).equals(findAnagrams("baa", "aa"));

        assert Arrays.asList(0,6).equals(findAnagrams("cbaebabacd", "abc"));

        assert Arrays.asList(0,1,2).equals(findAnagrams("abab", "ab"));

        System.out.println("ok");
    }
}
