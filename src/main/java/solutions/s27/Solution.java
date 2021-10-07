package solutions.s27;

import org.junit.Assert;
import org.junit.Test;

/**
 * 27. 移除元素
 * @Author weixun
 * @Date 2021-10-06
 * @See https://leetcode-cn.com/problems/remove-element/
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        int cur = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[cur + 1] = nums[i];
                cur++;
            }
        }
        return cur + 1;
    }


    @Test
    public void test() {

        Assert.assertEquals(2, removeElement(new int[]{3,2,2,3}, 3));

        Assert.assertEquals(5, removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));

        System.out.println("ok");
    }
}
