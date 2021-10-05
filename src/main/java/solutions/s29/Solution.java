package solutions.s29;

import base.ListNode;
import org.junit.Assert;
import org.junit.Test;


/**
 * @Author weixun
 * @Date 2021-10-02
 * @See https://leetcode-cn.com/problems/divide-two-integers/
 */
public class Solution {

    public int divide(int dividend, int divisor) {
        int count = 0;
        boolean isNeg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        dividend = dividend > 0 ? dividend : -dividend;
        divisor = divisor > 0 ? divisor : -divisor;

        while(dividend > divisor) {
            dividend -= divisor;
            count++;
        }

        return isNeg ? -count : count ;
    }

    @Test
    public void test() {

        Assert.assertEquals(3, divide(10, 3));

        Assert.assertEquals(-2, divide(7, -3));

        System.out.println("ok");
    }
}
