package solutions.s7;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author weixun
 * @Date 2021-09-17
 * @See https://leetcode-cn.com/problems/reverse-integer/
 */
public class Solution {

    public int reverse(int x) {
        long nx = 0;
        while(x != 0) {
            if (nx > Integer.MAX_VALUE / 10 || nx < Integer.MIN_VALUE / 10) {
                return 0;
            }
            nx = (nx * 10 + x % 10);
            x = x / 10;
        }

        return (int)nx;
    }

    @Test
    public void test() {
        Assert.assertEquals(321, reverse(123));

        Assert.assertEquals(-321, reverse(-123));

        Assert.assertEquals(21, reverse(120));

        Assert.assertEquals(0, reverse(0));

        Assert.assertEquals(0, reverse(1534236469));

        System.out.println("ok");
    }
}
