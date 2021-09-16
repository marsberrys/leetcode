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

    @Test
    public void test() {
        Solution solution = new Solution();

        solution.longestPalindrome("babad");

        Assert.assertEquals("bab", solution.longestPalindrome("babad"));

        Assert.assertEquals("bb", solution.longestPalindrome("cbbd"));

        Assert.assertEquals("a", solution.longestPalindrome("a"));

        Assert.assertEquals("a", solution.longestPalindrome("ac"));

        System.out.println("ok");
    }
}
