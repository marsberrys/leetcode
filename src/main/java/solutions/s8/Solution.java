package solutions.s8;

import org.junit.Assert;
import org.junit.Test;

/**
 * 字符串转换整数 (atoi)
 * @Author weixun
 * @Date 2021-09-17
 * @See https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class Solution {

    public int myAtoi(String s) {
        if(null == s) {
            return 0;
        }
        s = s.trim();
        int len = s.length();
        if(len == 0) {
            return 0;
        }

        char[] sArray = s.toCharArray();
        long target = 0l;
        int positive = 1;
        for (int i = 0; i < len; i++) {
            if(i == 0) {
                if(sArray[i] == '-') {
                    positive = -1;
                    continue;
                }
                if(sArray[i] == '+') {
                    continue;
                }
            }

            if(Character.isDigit(sArray[i])) {
                target = target * 10 + Character.getNumericValue(sArray[i]);
                if(positive * target >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if(positive * target <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }

        return positive * (int) target;
    }

    @Test
    public void test() {

        Assert.assertEquals(2147483647, myAtoi("2147483648"));

        Assert.assertEquals(2147483646, myAtoi("2147483646"));

        Assert.assertEquals(42, myAtoi("42"));

        Assert.assertEquals(-42, myAtoi("   -42"));

        Assert.assertEquals(4193, myAtoi("4193 with words"));

        Assert.assertEquals(0, myAtoi("words and 987"));

        Assert.assertEquals(-2147483648, myAtoi("-91283472332"));

        System.out.println("ok");
    }
}
