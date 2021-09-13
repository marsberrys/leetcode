package solutions.s1;

import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;

/**
 * @Author weixun
 * @Date 2021-09-10
 * @See https://leetcode-cn.com/problems/two-sum/
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if(map.containsKey(need)) {
                result[0] = map.get(need);
                result[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    @Test
    public void test() {
        Solution solution = new Solution();

        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        Assert.assertArrayEquals(solution.twoSum(nums, target), new int[]{0, 1});

        nums = new int[]{3,2,4};
        target = 6;
        Assert.assertArrayEquals(solution.twoSum(nums, target), new int[]{1,2});

        nums = new int[]{3,3};
        target = 6;
        Assert.assertArrayEquals(solution.twoSum(nums, target), new int[]{0,1});

        System.out.println("ok");
    }
}
