package solutions.s53_s2129;

import org.junit.Assert;
import org.junit.Test;

/**
 * 53. 最大子序和
 * 剑指 Offer 42. 连续子数组的最大和
 * @Author weixun
 * @Date 2021-10-02
 * @See https://leetcode-cn.com/problems/maximum-subarray/
 * @See https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len == 0) {
            return 0;
        }

        int dp = 0, max = nums[0];
        for (int num : nums) {
            dp = Math.max(dp + num, num);
            max = Math.max(max, dp);
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
