package solutions.s11;

import org.junit.Assert;
import org.junit.Test;

/**
 * 11. 盛最多水的容器
 * @Author weixun
 * @Date 2021-10-05
 * @See https://leetcode-cn.com/problems/container-with-most-water/
 */
public class Solution {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0, j = height.length - 1;
        while(i < j) {
            maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            if(height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }


    @Test
    public void test() {

        Assert.assertEquals(49, maxArea(new int[]{1,8,6,2,5,4,8,3,7}));

        Assert.assertEquals(1, maxArea(new int[]{1,1}));

        Assert.assertEquals(16, maxArea(new int[]{4,3,2,1,4}));

        Assert.assertEquals(2, maxArea(new int[]{1,2,1}));


        System.out.println("ok");
    }
}
