package solutions.s42;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author weixun
 * @Date 2021-09-26
 * @See https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class Solution {

    public int trap(int[] height) {
        if(null == height || height.length <= 0) {
            return 0;
        }

        int total = 0;
        int len = height.length;
        int[] leftMaxMap = new int[len];
        leftMaxMap[0] = 0;
        for (int i = 1; i < len; i++) {
            leftMaxMap[i] = Math.max(height[i - 1], leftMaxMap[i - 1]);
        }
        int[] rightMaxMap = new int[len];
        rightMaxMap[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            rightMaxMap[i] = Math.max(height[i + 1], rightMaxMap[i + 1]);
        }

        for (int i = 0; i < len; i++) {
            total += Math.max(0, Math.min(leftMaxMap[i], rightMaxMap[i]) - height[i]);
        }

        return total;
    }

    /**
     * 双指针实现
     * @param height
     * @return
     */
    public int trapDoublePointer(int[] height) {
        if(null == height || height.length < 3) {
            return 0;
        }

        int ans = 0;
        int len = height.length;
        int leftMax = height[0], rightMax = height[len - 1];
        int leftPointer = 0, rightPointer = len - 1;
        while (leftPointer < rightPointer) {
            leftMax = Math.max(leftMax, height[leftPointer]);
            rightMax = Math.max(rightMax, height[rightPointer]);
            if(height[leftPointer] < height[rightPointer]) {
                ans += leftMax - height[leftPointer];
                leftPointer++;
            } else {
                ans += rightMax - height[rightPointer];
                rightPointer--;
            }
        }

        return ans;
    }


    @Test
    public void test() {

        Assert.assertEquals(6, trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));

        Assert.assertEquals(9, trap(new int[]{4,2,0,3,2,5}));


        Assert.assertEquals(6, trapDoublePointer(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));

        Assert.assertEquals(9, trapDoublePointer(new int[]{4,2,0,3,2,5}));

        System.out.println("ok");
    }
}
