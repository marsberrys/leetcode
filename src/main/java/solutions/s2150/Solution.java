package solutions.s2150;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * @Author weixun
 * @Date 2021-10-30
 * @See https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 */
public class Solution {

    public int[][] findContinuousSequence(int target) {
        int l = 1, r = 2;
        List<int[]> res = new ArrayList<>();
        while(l < r) {
            int sum = (r + l) * (r - l + 1) / 2;
            if(sum == target) {
                res.add(genRes(l, r));
                l++;
            } else if(sum < target) {
                r++;
            } else {
                l++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    private int[] genRes(int left, int right) {
        int len = right - left + 1;
        int[] res = new int[len];
        for(int i = 0; i < len; i++) {
            res[i] = i + left;
        }
        return res;
    }

    @Test
    public void test() {

        Assert.assertArrayEquals(new int[][]{{2,3,4},{4,5}}, findContinuousSequence(9));

        Assert.assertArrayEquals(new int[][]{{1,2,3,4,5},{4,5,6},{7,8}}, findContinuousSequence(15));

        System.out.println("ok");
    }
}
