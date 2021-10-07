package solutions.s414;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 414. 第三大的数
 * @Author weixun
 * @Date 2021-10-06
 * @See https://leetcode-cn.com/problems/third-maximum-number/
 */
public class Solution {

    public int thirdMax(int[] nums) {
        Integer first = null, second = null, third = null;

        for (int i = 0; i < nums.length; i++) {

            if(first == null || nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];
                continue;
            } else if(first == nums[i]) {
                continue;
            } else if(second == null || nums[i] > second) {
                third = second;
                second = nums[i];
                continue;
            } else if(second == nums[i]) {
                continue;
            } else if(third == null || nums[i] > third) {
                third = nums[i];
            }
        }

        return third == null ? first : third;
    }


    @Test
    public void test() {

        Assert.assertEquals(1, thirdMax(new int[]{3, 2, 1}));

        Assert.assertEquals(2, thirdMax(new int[]{1, 2}));

        Assert.assertEquals(1, thirdMax(new int[]{2, 2, 3, 1}));

        System.out.println("ok");
    }
}
