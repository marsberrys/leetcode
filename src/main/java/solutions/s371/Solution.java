package solutions.s371;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author weixun
 * @Date 2021-09-26
 * @See https://leetcode-cn.com/problems/sum-of-two-integers/
 */
public class Solution {

    public int getSum(int a, int b) {
        if(a == 0) {
            return b;
        }
        if(b == 0) {
            return a;
        }

        while(b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }

        return a;
    }


    @Test
    public void test() {
        Solution solution = new Solution();

        Assert.assertEquals(3, solution.getSum(1, 2));

        Assert.assertEquals(5, solution.getSum(2, 3));

        System.out.println("ok");
    }
}
