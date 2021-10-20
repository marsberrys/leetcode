package solutions.s16;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 16. 最接近的三数之和
 * @Author weixun
 * @Date 2021-10-21
 * @See https://leetcode-cn.com/problems/3sum-closest/
 */
public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int best = (int)10e4;
        int len = nums.length;

        for(int i = 0; i < len; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1, r = len - 1;
            while(l < r) {
                int currSum = nums[i] + nums[l] + nums[r];
                if(currSum == target) {
                    return currSum;
                }
                if(Math.abs(currSum - target) < Math.abs(best - target)) {
                    best = currSum;
                }
                if(currSum < target) {
                    l += 1;
                } else {
                    r -= 1;
                }
            }
        }

        return best;
    }


    @Test
    public void test() {

        Assert.assertEquals(2, threeSumClosest(new int[]{-1,2,1,-4}, 1));

        System.out.println("ok");
    }
}
