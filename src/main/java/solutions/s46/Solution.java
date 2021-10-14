package solutions.s46;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. 全排列
 * @Author weixun
 * @Date 2021-10-14
 * @See https://leetcode-cn.com/problems/permutations/
 */
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        gen(nums, 0, res);
        return res;
    }

    private void gen(int[] nums, int from, List<List<Integer>> res) {
        if(from == nums.length - 1) {
            List<Integer> row = new ArrayList<>();
            for(int num : nums) {
                row.add(num);
            }
            res.add(row);
        }

        for(int i = from; i < nums.length; i++) {
            // 交换
            int tmp = nums[i];
            nums[i] = nums[from];
            nums[from] = tmp;

            gen(nums, from + 1, res);

            // 换回来
            nums[from] = nums[i];
            nums[i] = tmp;
        }
    }


    @Test
    public void test() {

        Arrays.asList(
            Arrays.asList(1,2,3),
            Arrays.asList(1,3,2),
            Arrays.asList(2,1,3),
            Arrays.asList(2,3,1),
            Arrays.asList(3,1,2),
            Arrays.asList(3,2,1)
        ).equals(permute(new int[]{1,2,3}));

        Arrays.asList(
            Arrays.asList(0,1),
            Arrays.asList(1,0)
        ).equals(permute(new int[]{0,1}));

        Arrays.asList(
            Arrays.asList(1)
        ).equals(permute(new int[]{1}));

        System.out.println("ok");
    }
}
