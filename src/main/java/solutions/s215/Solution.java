package solutions.s215;

import org.junit.Assert;
import org.junit.Test;

/**
 * 215. 数组中的第K个最大元素
 * @Author weixun
 * @Date 2021-10-14
 * @See https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    private int quickSelect(int[] nums, int left, int right, int index) {
        int mid = partion(nums, left, right);
        if(mid == index) {
            return nums[mid];
        }
        if(mid > index) {
            return quickSelect(nums, left, mid - 1, index);
        }

        return quickSelect(nums, mid + 1, right, index);
    }

    private int partion(int[] nums, int left, int right) {
        int base = nums[left];
        int l = left;
        int r = right;
        while(l < r) {
            while(base >= nums[r] && l < r) {
                r--;
            }
            while(base <= nums[l] && l < r) {
                l++;
            }
            swap(nums, l, r);
        }

        swap(nums, left, l);
        return l;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[right];
        nums[right] = nums[left];
        nums[left] = tmp;
    }

    @Test
    public void test() {

        Assert.assertEquals(5, findKthLargest(new int[]{3,2,1,5,6,4}, 2));

        Assert.assertEquals(4, findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));

        System.out.println("ok");
    }

}
