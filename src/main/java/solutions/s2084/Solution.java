package solutions.s2084;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * @Author weixun
 * @Date 2021-10-08
 * @See https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class Solution {

    public int findRepeatNumber(int[] nums) {
        // int i = 0;
        // while(i < nums.length) {
        //     if(nums[i] == i) {
        //         i++;
        //         continue;
        //     }
        //
        //     if(nums[i] == nums[nums[i]]) {
        //         return nums[i];
        //     }
        //
        //     int tmp = nums[nums[i]];
        //     nums[nums[i]] = nums[i];
        //     nums[i] = tmp;
        // }
        //
        // return -1;

        int len = nums.length;
        for(int i = 0; i < len; i++) {
            int cur = nums[i];
            if(cur == i) {
                continue;
            }
            if(nums[cur] == cur) {
                return cur;
            }

            // 把数字换到正确下标
            int tmp = nums[cur];
            nums[cur] = cur;
            nums[i] = tmp;
        }

        return nums[len - 1] == len - 1 ? -1 : nums[len - 1];
    }


    @Test
    public void test() {

        assert Arrays.asList(2,3).contains(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));

        assert Arrays.asList(0).contains(findRepeatNumber(new int[]{3, 4, 2, 0, 0, 1}));

        System.out.println("ok");
    }
}
