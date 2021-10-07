package solutions.s80;

import org.junit.Assert;
import org.junit.Test;

/**
 * 80. 删除有序数组中的重复项 II
 * @Author weixun
 * @Date 2021-10-06
 * @See https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            if(cur == 0 || nums[i] != nums[cur - 1]) {
                nums[++cur] = nums[i];
                continue;
            }
        }

        return cur + 1;
    }


    @Test
    public void test() {

        Assert.assertEquals(5, removeDuplicates(new int[]{1,1,1,2,2,3}));

        Assert.assertEquals(7, removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));

        System.out.println("ok");
    }
}
