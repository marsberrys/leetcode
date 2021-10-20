package solutions.s31;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;


/**
 * 31. 下一个排列
 * @Author weixun
 * @Date 2021-10-21
 * @See https://leetcode-cn.com/problems/next-permutation/
 */
public class Solution {

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int little = len - 2;

        for(;little >= 0; little--) {
            if(nums[little] < nums[little + 1]) {
                break;
            }
        }

        int bigger = len - 1;
        if(little >= 0) {
            for(;bigger > little; bigger--) {
                if(nums[bigger] > nums[little]) {
                    break;
                }
            }

            swap(nums, little, bigger);
        }

        int j = len - 1, i = little + 1;
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    @Test
    public void test() {

        int[] nums1 = new int[]{1,2,3};
        nextPermutation(nums1);
        Assert.assertArrayEquals(new int[]{1,3,2}, nums1);

        int[] nums2 = new int[]{3,2,1};
        nextPermutation(nums2);
        Assert.assertArrayEquals(new int[]{1,2,3}, nums2);

        int[] nums3 = new int[]{1,1,5};
        nextPermutation(nums3);
        Assert.assertArrayEquals(new int[]{1,5,1}, nums3);

        int[] nums4 = new int[]{1};
        nextPermutation(nums4);
        Assert.assertArrayEquals(new int[]{1}, nums4);

        System.out.println("ok");
    }
}
