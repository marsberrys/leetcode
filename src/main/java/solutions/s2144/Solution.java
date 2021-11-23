package solutions.s2144;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 剑指 Offer 13. 机器人的运动范围
 * @Author weixun
 * @Date 2021-11-23
 * @See https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class Solution {

    private static final int[][] MAP = new int[][]{{0,1},{1,0}};

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return searchMaxPath(m, n, k, visited, 0, 0);
    }

    private int searchMaxPath(int m, int n, int k, boolean[][] visited, int i, int j) {
        if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || getSum(i, j) > k) {
            return 0;
        }

        int max = 0;
        visited[i][j] = true;
        for(int cnt = 0; cnt < MAP.length; cnt++) {
            max += searchMaxPath(m, n, k, visited, i + MAP[cnt][0], j + MAP[cnt][1]);
        }
        return max + 1;
    }

    private int getSum(int ni, int nj) {
        int sum = 0;
        while(ni > 0) {
            sum += ni % 10;
            ni /= 10;
        }
        while(nj > 0) {
            sum += nj % 10;
            nj /= 10;
        }

        return sum;
    }

    @Test
    public void test() {

        Assert.assertEquals(3, movingCount(2, 3, 1));

        Assert.assertEquals(1, movingCount(3, 1, 0));

        System.out.println("ok");
    }
}
