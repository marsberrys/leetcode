package solutions.s695;

import base.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 695. 岛屿的最大面积
 * @Author weixun
 * @Date 2021-11-28
 * @See https://leetcode-cn.com/problems/max-area-of-island/
 */
public class Solution {

    private static final int[][] route = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        int rows = grid.length, cols = grid[0].length;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(max, searchIsland(grid, i , j));
                }
            }
        }

        return max;
    }

    private int searchIsland(int[][] grid, int i, int j) {
        int area = 0;
        grid[i][j] = -1;

        for(int k = 0; k < route.length; k++) {
            int ni = i + route[k][0];
            int nj = j + route[k][1];
            if(ni < 0 || nj < 0 || ni >= grid.length || nj >= grid[0].length || grid[ni][nj] <= 0) {
                continue;
            }
            area += searchIsland(grid, ni, nj);
        }

        return area + 1;
    }


    @Test
    public void test() {

        Assert.assertEquals(6, maxAreaOfIsland(new int[][]{
                new int[]{0,0,1,0,0,0,0,1,0,0,0,0,0},
                new int[]{0,0,0,0,0,0,0,1,1,1,0,0,0},
                new int[]{0,1,1,0,1,0,0,0,0,0,0,0,0},
                new int[]{0,1,0,0,1,1,0,0,1,0,1,0,0},
                new int[]{0,1,0,0,1,1,0,0,1,1,1,0,0},
                new int[]{0,0,0,0,0,0,0,0,0,0,1,0,0}
        }));

        Assert.assertEquals(0, maxAreaOfIsland(new int[][]{
                new int[]{0,0,0,0,0,0,0,0}
        }));

        System.out.println("ok");
    }
}
