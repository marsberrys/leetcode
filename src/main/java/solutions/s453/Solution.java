package solutions.s453;

import base.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 453. 最小操作次数使数组元素相等
 * @Author weixun
 * @Date 2021-10-20
 * @See https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/
 */
public class Solution {

    public int minMoves(int[] nums) {
        if(nums.length <= 0) {
            return 0;
        }
        int min = nums[0];
        int op = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < min) {
                op += i * (min - nums[i]);
                min = nums[i];
            }

            op += nums[i] - min;
        }

        return op;
    }

    @Test
    public void test() {

        Assert.assertEquals(3, minMoves(new int[]{1,2,3}));

        Assert.assertEquals(0, minMoves(new int[]{1,1,1}));

        System.out.println("ok");
    }
}
