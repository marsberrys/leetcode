package solutions.s69;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 69. Sqrt(x)
 * @Author weixun
 * @Date 2021-10-10
 * @See https://leetcode-cn.com/problems/sqrtx/
 */
public class Solution {

    public int mySqrt(int x) {
        int l = 0, r = x;
        int res = 0;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if((long) mid * mid <= x) {
                l = mid + 1;
                res = mid;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }

    @Test
    public void test() {

        Assert.assertEquals(2, mySqrt(4));

        Assert.assertEquals(2, mySqrt(8));

        System.out.println("ok");
    }
}
