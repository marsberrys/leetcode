package solutions.s39;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 39. 组合总和
 * @Author weixun
 * @Date 2021-11-03
 * @See https://leetcode-cn.com/problems/combination-sum/
 */
public class Solution {

    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        search(candidates, target, sub, 0);
        return res;
    }

    private void search(int[] candidates, int target, List<Integer> sub, int min) {
        int len = candidates.length;
        int i = 0;
        while(i < len && candidates[i] < min) {
            i++;
        }
        while(i < len) {
            sub.add(candidates[i]);
            if(candidates[i] == target) {
                res.add(new ArrayList<>(sub));
            } else if(candidates[i] < target) {
                search(candidates, target - candidates[i], sub, Math.max(min, candidates[i]));
            } else {
                i = len - 1;
            }
            sub.remove(sub.size() - 1);
            i++;
        }
    }

    @Test
    public void test() {

        assert Arrays.asList(
                Arrays.asList(2,2,3),
                Arrays.asList(7)
        ).equals(combinationSum(new int[]{2,3,6,7}, 7));

        assert Arrays.asList(
                Arrays.asList(2,2,2,2),
                Arrays.asList(2,3,3),
                Arrays.asList(3,5)
        ).equals(combinationSum(new int[]{2,3,5}, 8));

        assert Arrays.asList().equals(combinationSum(new int[]{2}, 1));

        assert Arrays.asList(Arrays.asList(1)).equals(combinationSum(new int[]{1}, 1));

        System.out.println("ok");
    }
}
