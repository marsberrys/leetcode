package solutions.s223;

import base.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author weixun
 * @Date 2021-09-30
 * @See https://leetcode-cn.com/problems/rectangle-area/
 */
public class Solution {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaA = (ay2 - ay1) * (ax2 - ax1);
        int areaB = (by2 - by1) * (bx2 - bx1);
        int areaCover = Math.max(0, (Math.min(ax2, bx2) - Math.max(ax1, bx1))) * Math.max(0, (Math.min(ay2, by2) - Math.max(ay1, by1)));

        return areaA + areaB - areaCover;
    }

    @Test
    public void test() {

        Assert.assertEquals(45, computeArea(-3, 0, 3, 4, 0, -1, 9, 2));

        Assert.assertEquals(16, computeArea(-2, -2, 2, 2, -2, -2, 2, 2));

        Assert.assertEquals(17, computeArea(-2, -2, 2, 2, 3, 3, 4, 4));

        System.out.println("ok");
    }
}
