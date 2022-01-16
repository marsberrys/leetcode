package solutions.s3;

import base.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * @Author weixun
 * @Date 2021-09-13
 * @See https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0;
        Set<Character> set = new HashSet();
        int max = 0;
        while(end < s.length()) {
            Character ch = s.charAt(end);
            if(set.contains(ch)) {
                set.remove(s.charAt(start));
                start++;
                continue;
            }

            set.add(ch);
            end++;
            if(max < set.size()) {
                max = set.size();
            }
        }

        return max;
    }

    @Test
    public void test() {

        Assert.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));

        Assert.assertEquals(1, lengthOfLongestSubstring("bbbbb"));

        Assert.assertEquals(3, lengthOfLongestSubstring("pwwkew"));

        Assert.assertEquals(0, lengthOfLongestSubstring(""));

        Assert.assertEquals(5, lengthOfLongestSubstring("qrsvbspk"));

        System.out.println("ok");
    }
}
