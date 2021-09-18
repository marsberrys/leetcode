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
        Solution solution = new Solution();

        Assert.assertEquals(321, solution.reverse(123));

        Assert.assertEquals(-321, solution.reverse(-123));

        Assert.assertEquals(21, solution.reverse(120));

        Assert.assertEquals(0, solution.reverse(0));

        Assert.assertEquals(0, solution.reverse(1534236469));

        System.out.println("ok");
    }
}
