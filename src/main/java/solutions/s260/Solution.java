package solutions.s260;

import org.junit.Assert;
import org.junit.Test;


/**
 * 260. 只出现一次的数字 III
 * @Author weixun
 * @Date 2021-10-30
 * @See https://leetcode-cn.com/problems/single-number-iii/
 */
public class Solution {

    public int[] singleNumber(int[] nums) {
        int len = nums.length;
        if(len <= 2) {
            return nums;
        }

        int[] res = new int[2];
        int xorsum = 0;
        for(int num : nums) {
            xorsum ^= num;
        }

        int lowBit1 = xorsum == Integer.MIN_VALUE ? xorsum : xorsum & -xorsum;
        for(int num : nums) {
            if((num & lowBit1) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }

        return res;
    }

    @Test
    public void test() {

        Assert.assertArrayEquals(new int[]{5,3}, singleNumber(new int[]{1,2,1,3,2,5}));

        Assert.assertArrayEquals(new int[]{-1,0}, singleNumber(new int[]{-1,0}));

        Assert.assertArrayEquals(new int[]{1,0}, singleNumber(new int[]{1,0}));

        System.out.println("ok");
    }
}
