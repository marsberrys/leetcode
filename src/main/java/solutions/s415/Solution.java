package solutions.s415;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * 415. 字符串相加
 * @Author weixun
 * @Date 2021-10-10
 * @See https://leetcode-cn.com/problems/add-strings/
 */
public class Solution {

    public String addStrings(String num1, String num2) {
        char[] chars1 = num1.toCharArray(), chars2 = num2.toCharArray();
        int i = num1.length() - 1, j = num2.length() - 1;

        StringBuilder sb = new StringBuilder();
        int over = 0;

        while(i >= 0 || j >= 0) {
            int a = i >= 0 ? chars1[i] - '0' : 0;
            int b = j >= 0 ? chars2[j] - '0' : 0;

            int bit = a + b + over;
            if(bit >= 10) {
                bit %= 10;
                over = 1;
            } else {
                over = 0;
            }

            sb.insert(0, bit);

            i--;
            j--;
        }

        if(over > 0) {
            sb.insert(0, over);
        }

        return sb.toString();
    }

    @Test
    public void test() {

        Assert.assertEquals("134", addStrings("11", "123"));

        Assert.assertEquals("533", addStrings("456", "77"));

        Assert.assertEquals("0", addStrings("0", "0"));

        System.out.println("ok");
    }
}
