package solutions.s66;

import org.junit.Assert;
import org.junit.Test;


/**
 * 66. 加一
 * @Author weixun
 * @Date 2021-10-21
 * @See https://leetcode-cn.com/problems/plus-one/
 */
public class Solution {

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if(digits[len - 1] != 9) {
            digits[len - 1] += 1;
            return digits;
        }

        int i = len - 1;
        while(i >= 0 && digits[i] == 9) {
            digits[i] = 0;
            i--;
        }

        if(i >= 0) {
            digits[i] += 1;
            return digits;
        }

        int[] res = new int[len + 1];
        res[0] = 1;

        return res;
    }

    @Test
    public void test() {

        Assert.assertArrayEquals(new int[]{1,2,4}, plusOne(new int[]{1,2,3}));

        Assert.assertArrayEquals(new int[]{4,3,2,2}, plusOne(new int[]{4,3,2,1}));

        Assert.assertArrayEquals(new int[]{1}, plusOne(new int[]{0}));

        Assert.assertArrayEquals(new int[]{100}, plusOne(new int[]{99}));

        Assert.assertArrayEquals(new int[]{1,0,0}, plusOne(new int[]{9,9}));

        System.out.println("ok");
    }
}
