package solutions.s3;

import base.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
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
        Solution solution = new Solution();

        Assert.assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));

        Assert.assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));

        Assert.assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));

        Assert.assertEquals(0, solution.lengthOfLongestSubstring(""));

        Assert.assertEquals(5, solution.lengthOfLongestSubstring("qrsvbspk"));

        System.out.println("ok");
    }
}
