package solutions.s121;

import org.junit.Assert;
import org.junit.Test;

/**
 * 121. 买卖股票的最佳时机
 * @Author weixun
 * @Date 2021-10-07
 * @See https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            if(minPrice > prices[i]) {
                minPrice = prices[i];
            }
            if(prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

    @Test
    public void test() {

        Assert.assertEquals(5, maxProfit(new int[]{7,1,5,3,6,4}));

        Assert.assertEquals(0, maxProfit(new int[]{7,6,4,3,1}));


        System.out.println("ok");
    }
}
