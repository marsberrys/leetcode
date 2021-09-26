package solutions.s2012;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author weixun
 * @Date 2021-09-25
 * @See https://leetcode-cn.com/problems/delete-operation-for-two-strings/
 */
public class Solution {

    public int sumOfBeauties(int[] nums) {
        int len = nums.length;
        if(len < 3) {
            return 0;
        }

        int leftMax = nums[0], rightMin = nums[len - 1];
        boolean[] tmpCheck = new boolean[len];

        // 从左到右，检查每个位置是否满足 0 <= j < i 且 nums[j] < nums[i]
        for (int i = 1; i < len - 1; i++) {
            if(nums[i - 1] > leftMax) {
                leftMax = nums[i - 1];
            }

            tmpCheck[i] = nums[i] > leftMax;
        }

        // 从左到右，检查每个位置是否满足 i < k <= nums.length - 1 且 nums[i] < nums[k]
        for (int i = len - 2; i >= 0; i--) {
            if(nums[i + 1] < rightMin) {
                rightMin = nums[i + 1];
            }

            tmpCheck[i] = nums[i] < rightMin && tmpCheck[i];
        }

        int beautiesSum = 0;
        for (int i = 1; i < len - 1; i++) {
            if(nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                if(tmpCheck[i]) {
                    beautiesSum += 2;
                } else {
                    beautiesSum ++;
                }
            }
        }

        return beautiesSum;
    }


    @Test
    public void test() {
        Solution solution = new Solution();

        Assert.assertEquals(2, solution.sumOfBeauties(new int[]{1, 2, 3}));

        Assert.assertEquals(1, solution.sumOfBeauties(new int[]{2, 4, 6, 4}));

        Assert.assertEquals(0, solution.sumOfBeauties(new int[]{3, 2, 1}));

        Assert.assertEquals(4, solution.sumOfBeauties(new int[]{1, 2, 3, 4}));

        Assert.assertEquals(13, solution.sumOfBeauties(new int[]{3, 2, 3, 4, 5, 6, 7, 8, 9, 10}));

        Assert.assertEquals(7, solution.sumOfBeauties(new int[]{3, 2, 3, 4, 5, 6, 3, 8, 9, 10}));

        Assert.assertEquals(5, solution.sumOfBeauties(new int[]{3, 2, 4, 1, 5, 8, 6, 7, 9, 10}));

        System.out.println("ok");
    }
}
