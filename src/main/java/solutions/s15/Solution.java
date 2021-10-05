package solutions.s15;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @Author weixun
 * @Date 2021-10-04
 * @See https://leetcode-cn.com/problems/3sum/
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        for (int first = 0; first < len - 2; first++) {
            if(first != 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int third = len - 1;
            for (int second = first + 1; second < len - 1; second++) {
                if(second != first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while(second < third && nums[second] + nums[third] > -nums[first]) {
                    third--;
                }

                if(second != third && nums[second] + nums[third] + nums[first] == 0) {
                    result.add(Arrays.asList(nums[first], nums[second], nums[third]));
                }
            }
        }

        return result;
    }


    @Test
    public void test() {

        assert Arrays.asList(
                Arrays.asList(-1,-1,2),
                Arrays.asList(-1,0,1)
        ).equals(threeSum(new int[]{-1,0,1,2,-1,-4}));

        assert Arrays.asList().equals(threeSum(new int[]{}));

        assert Arrays.asList().equals(threeSum(new int[]{0}));

        assert Arrays.asList(Arrays.asList(-1,0,1)).equals(threeSum(new int[]{1,-1,-1,0}));

        assert Arrays.asList().equals(threeSum(new int[]{1,2,-2,-1}));

        System.out.println("ok");
    }
}
