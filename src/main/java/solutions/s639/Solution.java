package solutions.s639;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * @Author weixun
 * @Date 2021-09-27
 * @See https://leetcode-cn.com/problems/decode-ways-ii/
 */
public class Solution {

    private static int MOD = (int)1e9+7;

    public int numDecodings(String s) {
        char[] sChars = s.toCharArray();
        long f0 = 1, f1 = 1, f2 = 0; // 此处用 long 是因为数值可能很大超出 int
        for (int i = 0; i < s.length(); i++) {
            f2 = f1 * checkOneChar(sChars[i]) % MOD;
            if(i > 0) {
                f2 = (f2 + f0 * checkTwoChar(sChars[i - 1], sChars[i])) % MOD;
            }
            f0 = f1;
            f1 = f2;
        }

        return (int)f2;
    }

    private int checkOneChar(char ch) {
        if(ch == '0') {
            return 0;
        } else if(ch == '*') {
            return 9;
        }
        return 1;
    }

    private int checkTwoChar(char ch0, char ch1) {
        if(ch0 == '*' && ch1 == '*') {
            return 15;
        }
        if(ch0 == '*') {
            return ch1 <= '6' ? 2 : 1;
        }
        if(ch1 == '*') {
            if(ch0 == '1') {
                return 9;
            }
            if(ch0 == '2') {
                return 6;
            }
            return 0;
        }

        if(ch0 == '1') {
            return 1;
        }
        if(ch0 == '2' && ch1 <= '6') {
            return 1;
        }
        return 0;
    }


    @Test
    public void test() {
        Assert.assertEquals(9, numDecodings("*"));

        Assert.assertEquals(18, numDecodings("1*"));

        Assert.assertEquals(11, numDecodings("*1"));

        Assert.assertEquals(15, numDecodings("2*"));

        Assert.assertEquals(96, numDecodings("**"));

        Assert.assertEquals(196465252, numDecodings("7*9*3*6*3*0*5*4*9*7*3*7*1*8*3*2*0*0*6*"));

        System.out.println("ok");
    }
}
