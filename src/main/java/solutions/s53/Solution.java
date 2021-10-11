package solutions.s53;

import org.junit.Assert;
import org.junit.Test;

/**
 * 53. 最大子序和
 * @Author weixun
 * @Date 2021-10-02
 * @See https://leetcode-cn.com/problems/maximum-subarray/
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }

        int prev = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            prev = Math.max(prev + num, num);
            max = Math.max(max, prev);
        }

        return max;
    }


    @Test
    public void test() {

        Assert.assertEquals(6, maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

        Assert.assertEquals(1, maxSubArray(new int[]{1}));

        Assert.assertEquals(0, maxSubArray(new int[]{0}));

        Assert.assertEquals(-1, maxSubArray(new int[]{-1}));

        Assert.assertEquals(-100000, maxSubArray(new int[]{-100000}));

        System.out.println("ok");
    }
}
