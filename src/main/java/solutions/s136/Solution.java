package solutions.s136;

import base.TreeNode;
import org.junit.Assert;
import org.junit.Test;


/**
 * 136. 只出现一次的数字
 * @Author weixun
 * @Date 2021-10-30
 * @See https://leetcode-cn.com/problems/single-number/
 */
public class Solution {

    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    @Test
    public void test() {

        Assert.assertEquals(1, singleNumber(new int[]{2,2,1}));

        Assert.assertEquals(4, singleNumber(new int[]{4,1,2,1,2}));

        System.out.println("ok");
    }
}
