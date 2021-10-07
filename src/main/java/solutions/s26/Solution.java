package solutions.s26;

import org.junit.Assert;
import org.junit.Test;

/**
 * 26. 删除有序数组中的重复项
 * @Author weixun
 * @Date 2021-10-06
 * @See https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        int cur = 0, i = 0;
        while(i < nums.length) {
            if(nums[cur] != nums[i]) {
                cur++;
                nums[cur] = nums[i];
            }
            i++;
        }

        return cur + 1;
    }


    @Test
    public void test() {

        Assert.assertEquals(2, removeDuplicates(new int[]{1,1,2}));

        Assert.assertEquals(5, removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));

        System.out.println("ok");
    }
}
