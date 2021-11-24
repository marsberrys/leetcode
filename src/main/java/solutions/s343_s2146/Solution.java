package solutions.s343_s2146;

import org.junit.Assert;
import org.junit.Test;

/**
 * 343. 整数拆分
 * 剑指 Offer 14- I. 剪绳子
 * @Author weixun
 * @Date 2021-11-24
 * @See https://leetcode-cn.com/problems/integer-break/
 * @See https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 */
public class Solution {

    public int cuttingRope(int n) {
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i < n; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max((j + 1) * (i - j), (j + 1) * dp[i - j - 1]));
            }
        }

        return dp[n - 1];
    }


    @Test
    public void test() {

        Assert.assertEquals(1, cuttingRope(2));

        Assert.assertEquals(36, cuttingRope(10));

        System.out.println("ok");
    }
}
