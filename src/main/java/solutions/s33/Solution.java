package solutions.s33;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;


/**
 * 33. 搜索旋转排序数组
 * @Author weixun
 * @Date 2021-10-21
 * @See https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class Solution {

    public int search(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }

        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] >= nums[l]) {
                if(target < nums[mid] && target >= nums[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if(target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }

    @Test
    public void test() {

        Assert.assertEquals(1, search(new int[]{3,1}, 1));

        Assert.assertEquals(4, search(new int[]{4,5,6,7,0,1,2}, 0));

        Assert.assertEquals(-1, search(new int[]{4,5,6,7,0,1,2}, 3));

        Assert.assertEquals(-1, search(new int[]{1}, 0));

        System.out.println("ok");
    }
}
