package solutions.s10;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * 10. 正则表达式匹配
 * @Author weixun
 * @Date 2021-09-22
 * @See https://leetcode-cn.com/problems/regular-expression-matching/
 */
public class Solution {

    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] dp = new boolean[sLen][pLen];

        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < pLen; j++) {
                // TODO
                // if(pChars[j] == '*') {
                //     if(j >= 2 && dp[i][j - 2]) {
                //         dp[i][j] = true;
                //         continue;
                //     }
                //
                //     dp[i][j] = isCharMatch(sChars[i], pChars[j - 1]) && (i == 0 || dp[i - 1][j]);
                // } else {
                //     boolean subResult = i > 0 && j > 0 ? dp[i - 1][j - 1] : ();
                //
                //     dp[i][j] = isCharMatch(sChars[i], pChars[j]);
                //
                //     if(i > 0 && j > 0) {
                //         dp[i][j] = dp[i][j] && ;
                //     }
                // }
            }
        }

        return dp[sLen - 1][pLen - 1];
    }

    private boolean isCharMatch(char sChar, char pChar) {
        return sChar == pChar || pChar == '.';
    }

    @Test
    public void test() {

        Assert.assertEquals(false, isMatch("aa", "a"));

        Assert.assertEquals(true, isMatch("aa", "a*"));

        Assert.assertEquals(true, isMatch("ab", ".*"));

        Assert.assertEquals(true, isMatch("aab", "c*a*b"));

        Assert.assertEquals(false, isMatch("mississippi", "mis*is*p*."));

        System.out.println("ok");
    }
}
