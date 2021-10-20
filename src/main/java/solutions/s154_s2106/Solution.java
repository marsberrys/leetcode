package solutions.s154_s2106;

import org.junit.Assert;
import org.junit.Test;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 * @Author weixun
 * @Date 2021-10-12
 * @See https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class Solution {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left)/2;
            if(nums[mid] < nums[right]) {
                right = mid;
            } else if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }

        return nums[right];
    }


    @Test
    public void test() {

        Assert.assertEquals(1, findMin(new int[]{1,3,5}));

        Assert.assertEquals(0, findMin(new int[]{2,2,2,0,1}));

        System.out.println("ok");
    }
}
