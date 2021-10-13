package solutions.s122;

import org.junit.Assert;
import org.junit.Test;

/**
 * 122. 买卖股票的最佳时机 II
 * @Author weixun
 * @Date 2021-10-12
 * @See https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class Solution {

    /**
     * 动态规划
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2) {
            return 0;
        }

        int[][] dp = new int[len][2];
        // 0: 卖出
        // 1: 持有
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[len - 1][0];
    }

    /**
     * 贪心实现
     * @param prices
     * @return
     */
    public int maxProfitGreedy(int[] prices) {
        int len = prices.length;
        int max = 0;
        if(len < 2) {
            return max;
        }

        for (int i = 1; i < len; i++) {
            if(prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }

        return max;
    }

    @Test
    public void test() {
        Assert.assertEquals(7, maxProfit(new int[]{7,1,5,3,6,4}));

        Assert.assertEquals(4, maxProfit(new int[]{1,2,3,4,5}));

        Assert.assertEquals(0, maxProfit(new int[]{7,6,4,3,1}));

        // 贪心
        Assert.assertEquals(7, maxProfitGreedy(new int[]{7,1,5,3,6,4}));

        Assert.assertEquals(4, maxProfitGreedy(new int[]{1,2,3,4,5}));

        Assert.assertEquals(0, maxProfitGreedy(new int[]{7,6,4,3,1}));


        System.out.println("ok");
    }
}
