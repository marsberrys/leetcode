package solutions.s852_s2232;

import org.junit.Assert;
import org.junit.Test;

/**
 * 852. 山脉数组的峰顶索引
 * 剑指 Offer II 069. 山峰数组的顶部
 * @Author weixun
 * @Date 2021-10-14
 * @See https://leetcode-cn.com/problems/B1IidL/submissions/
 * @See https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 */
public class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if(arr[mid] > arr[mid - 1]) {
                left = mid;
            }
            if(arr[mid] < arr[mid - 1]) {
                right = mid;
            }
        }

        return left;
    }

    @Test
    public void test() {

        Assert.assertEquals(1, peakIndexInMountainArray(new int[]{0,1,0}));

        Assert.assertEquals(2, peakIndexInMountainArray(new int[]{1,3,5,4,2}));

        Assert.assertEquals(1, peakIndexInMountainArray(new int[]{0,10,5,2}));

        Assert.assertEquals(2, peakIndexInMountainArray(new int[]{3,4,5,1}));

        Assert.assertEquals(2, peakIndexInMountainArray(new int[]{24,69,100,99,79,78,67,36,26,19}));

        System.out.println("ok");
    }
}
