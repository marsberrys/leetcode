package solutions.s441;

import base.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 441. 排列硬币
 * @Author weixun
 * @Date 2021-10-10
 * @See https://leetcode-cn.com/problems/arranging-coins/
 */
public class Solution {

    public int arrangeCoins(int n) {
        int row = 0;
        while(n > row) {
            row++;
            n -= row;
        }

        return row;
    }

    @Test
    public void test() {

        Assert.assertEquals(0, arrangeCoins(0));

        Assert.assertEquals(1, arrangeCoins(1));

        Assert.assertEquals(1, arrangeCoins(2));

        Assert.assertEquals(2, arrangeCoins(3));

        Assert.assertEquals(2, arrangeCoins(5));

        Assert.assertEquals(3, arrangeCoins(8));

        System.out.println("ok");
    }
}
