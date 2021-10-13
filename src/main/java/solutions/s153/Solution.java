package solutions.s153;

import org.junit.Assert;
import org.junit.Test;

/**
 * 153. 寻找旋转排序数组中的最小值
 * @Author weixun
 * @Date 2021-10-12
 * @See https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class Solution {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left)/2;
            if(nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[right];
    }


    @Test
    public void test() {

        Assert.assertEquals(1, findMin(new int[]{3,4,5,1,2}));

        Assert.assertEquals(0, findMin(new int[]{4,5,6,7,0,1,2}));

        Assert.assertEquals(11, findMin(new int[]{11,13,15,17}));

        System.out.println("ok");
    }
}
