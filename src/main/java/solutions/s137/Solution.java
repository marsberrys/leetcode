package solutions.s137;

import org.junit.Assert;
import org.junit.Test;


/**
 * 137. 只出现一次的数字 II
 * @Author weixun
 * @Date 2021-10-19
 * @See https://leetcode-cn.com/problems/single-number-ii/
 */
public class Solution {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int total = 0;
            for(int num : nums) {
                total += ((num >> i) & 1);
            }
            if(total % 3 != 0) {
                ans |= (1 << i);
            }
        }

        return ans;
    }

    @Test
    public void test() {

        Assert.assertEquals(3, singleNumber(new int[]{2,2,3,2}));

        Assert.assertEquals(99, singleNumber(new int[]{0,1,0,1,0,1,99}));

        System.out.println("ok");
    }
}
