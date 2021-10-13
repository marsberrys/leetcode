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
        if(dividend == 0) {
            return 0;
        }
        if(divisor == 1) {
            return dividend;
        }
        if(divisor == -1) {
            if(dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return -dividend;
            }
        }
        if(divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }

        boolean isNeg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        if(dividend >= divisor) {
            return dividend > divisor ? 0 : (isNeg ? -1 : 1);
        }

        int res = 0;
        while(dividend <= divisor) {
            int a = dividend, b = divisor, cnt = 1;
            while(a - b <= b) {
                cnt += cnt;
                b += b;
            }
            res += cnt;
            dividend -= b;
        }

        return isNeg ? -res : res ;
    }

    @Test
    public void test() {

        Assert.assertEquals(3, divide(10, 3));

        Assert.assertEquals(-2, divide(7, -3));

        Assert.assertEquals(-1, divide(1, -1));

        Assert.assertEquals(-1, divide(10, -10));

        System.out.println("ok");
    }
}
