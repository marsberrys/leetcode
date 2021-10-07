package solutions.s167;

import org.junit.Assert;
import org.junit.Test;

/**
 * 167. 两数之和 II - 输入有序数组
 * @Author weixun
 * @Date 2021-10-05
 * @See https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                return new int[]{left + 1, right + 1};
            }
            if(sum > target) {
                right--;
            } else {
                left++;
            }
        }


        return new int[]{};
    }


    @Test
    public void test() {

        Assert.assertArrayEquals(new int[]{1,2}, twoSum(new int[]{2,7,11,15}, 9));

        Assert.assertArrayEquals(new int[]{1,3}, twoSum(new int[]{2,3,4}, 6));

        Assert.assertArrayEquals(new int[]{1,2}, twoSum(new int[]{-1,0}, -1));

        System.out.println("ok");
    }
}
