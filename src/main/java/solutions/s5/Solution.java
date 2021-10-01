package solutions.s5;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author weixun
 * @Date 2021-09-14
 * @See https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class Solution {

    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2) {
            return s;
        }


        int begin = 0;
        int maxLen = 1;
        char[] charArray = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        for (int testLen = 1; testLen <= len; testLen++) {
            for (int left = 0; left <= len - testLen; left++) {
                int right = left + testLen - 1;
                if(charArray[left] != charArray[right]) {
                    dp[left][right] = false;
                    continue;
                }

                if(left + 1 >= right - 1 || dp[left + 1][right - 1]) {
                    dp[left][right] = true;
                    if(testLen > maxLen) {
                        begin = left;
                        maxLen = testLen;
                    }
                } else {
                    dp[left][right] = false;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    /**
     * 中心扩展法
     * @param s
     * @return
     */
    public String longestPalindromeCenterExpansion(String s) {
        int len = s.length();
        if(len < 2) {
            return s;
        }


        int begin = 0;
        int maxLen = 1;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            int lenOfCenterSelf = expansionCenter(charArray, i, i);
            int lenOfCenterSelfAndNext = expansionCenter(charArray, i, i + 1);

            int currentMaxLen = Math.max(lenOfCenterSelf, lenOfCenterSelfAndNext);
            if(currentMaxLen > maxLen) {
                maxLen = currentMaxLen;
                begin = i - (currentMaxLen - 1) / 2;
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    private int expansionCenter(char[] chars, int left, int right) {
        while(left >= 0 && right < chars.length && chars[left] == chars[right]) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    @Test
    public void test() {
        Assert.assertEquals("bab", longestPalindrome("babad"));

        Assert.assertEquals("bb", longestPalindrome("cbbd"));

        Assert.assertEquals("a", longestPalindrome("a"));

        Assert.assertEquals("a", longestPalindrome("ac"));

        Assert.assertEquals("bab", longestPalindromeCenterExpansion("babad"));

        Assert.assertEquals("bb", longestPalindromeCenterExpansion("cbbd"));

        Assert.assertEquals("a", longestPalindromeCenterExpansion("a"));

        Assert.assertEquals("a", longestPalindromeCenterExpansion("ac"));

        System.out.println("ok");
    }
}
