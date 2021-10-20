package solutions.s35;

import org.junit.Assert;
import org.junit.Test;


/**
 * 35. 搜索插入位置
 * @Author weixun
 * @Date 2021-10-18
 * @See https://leetcode-cn.com/problems/search-insert-position/
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }

        return ans;
    }

    @Test
    public void test() {

        Assert.assertEquals(0, searchInsert(new int[]{1}, 1));

        Assert.assertEquals(2, searchInsert(new int[]{1,3,5,6}, 5));

        Assert.assertEquals(1, searchInsert(new int[]{1,3,5,6}, 2));

        Assert.assertEquals(4, searchInsert(new int[]{1,3,5,6}, 7));

        Assert.assertEquals(0, searchInsert(new int[]{1,3,5,6}, 0));

        Assert.assertEquals(0, searchInsert(new int[]{1,3,5,6}, 0));

        System.out.println("ok");
    }
}
