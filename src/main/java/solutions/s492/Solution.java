package solutions.s492;

import org.junit.Assert;
import org.junit.Test;

/**
 * 492. 构造矩形
 * @Author weixun
 * @Date 2021-10-20
 * @See https://leetcode-cn.com/problems/construct-the-rectangle/
 */
public class Solution {

    public int[] constructRectangle(int area) {
        int sqrt = (int)Math.sqrt(area);
        while(area % sqrt != 0) {
            sqrt--;
        }

        return new int[]{area / sqrt, sqrt};
    }

    @Test
    public void test() {

        Assert.assertArrayEquals(new int[]{2,2}, constructRectangle(4));

        Assert.assertArrayEquals(new int[]{37,1}, constructRectangle(37));

        System.out.println("ok");
    }
}
