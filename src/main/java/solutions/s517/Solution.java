package solutions.s517;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * @Author weixun
 * @Date 2021-09-29
 * @See https://leetcode-cn.com/problems/super-washing-machines/
 */
public class Solution {

    public int findMinMoves(int[] machines) {
        if(machines.length <= 0) {
            return -1;
        }

        int len = machines.length;
        int sum = 0;
        for (int num : machines) {
            sum += num;
        }

        if(sum % len != 0) {
            return -1;
        }

        int avg = sum / len;

        int max = 0;
        int lSum = 0, rSum = sum;
        for (int i = 0; i < len; i++) {
            rSum -= machines[i];
            int r2l = Math.max(i * avg - lSum, 0);
            int l2r = Math.max((len - i - 1) * avg - rSum, 0);
            max = Math.max(max, r2l + l2r);

            lSum += machines[i];
        }

        return max;
    }

    @Test
    public void test() {

        Assert.assertEquals(3, findMinMoves(new int[]{1,0,5}));

        Assert.assertEquals(2, findMinMoves(new int[]{0,3,0}));

        Assert.assertEquals(-1, findMinMoves(new int[]{0,2,0}));

        System.out.println("ok");
    }
}
