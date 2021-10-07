package solutions.s70;

import org.junit.Assert;
import org.junit.Test;

/**
 * 70. 爬楼梯
 * @Author weixun
 * @Date 2021-10-07
 * @See https://leetcode-cn.com/problems/climbing-stairs/
 */
public class Solution {

    public int climbStairs(int n) {
        int a = 0, b = 0, c = 1;

        for(int i = 1; i < n + 1; i++) {
            a = b;
            b = c;
            c = a + b;
        }

        return c;
    }

    @Test
    public void test() {

        Assert.assertEquals(2, climbStairs(2));

        Assert.assertEquals(3, climbStairs(3));


        System.out.println("ok");
    }
}
