package solutions.s322;

import base.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


/**
 * 322. 零钱兑换
 * @Author weixun
 * @Date 2021-12-01
 * @See https://leetcode-cn.com/problems/coin-change/
 */
public class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for(int i = 1; i <= amount; i++) {
            for(int coin : coins) {
                if(coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    @Test
    public void test() {

        Assert.assertEquals(3, coinChange(new int[]{1, 2, 5}, 11));

        Assert.assertEquals(-1, coinChange(new int[]{2}, 3));

        Assert.assertEquals(0, coinChange(new int[]{1}, 0));

        Assert.assertEquals(1, coinChange(new int[]{1}, 1));

        Assert.assertEquals(2, coinChange(new int[]{1}, 2));

        System.out.println("ok");
    }
}
