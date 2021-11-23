package solutions.s200;

import base.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 200. 岛屿数量
 * @Author weixun
 * @Date 2021-11-23
 * @See https://leetcode-cn.com/problems/number-of-islands/
 */
public class Solution {

    private static final int[][] MAP = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};

    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    search(grid, i, j);
                    ans++;
                }
            }
        }

        return ans;
    }

    private void search(char[][] grid, int i, int j) {
        if(grid[i][j] == '0' || grid[i][j] == '2') {
            return;
        }

        grid[i][j] = '2';
        for(int m = 0; m < MAP.length; m++) {
            int mi = i + MAP[m][0], mj = j + MAP[m][1];
            if(mi < 0 || mj < 0 || mi >= grid.length || mj >= grid[0].length) {
                continue;
            }
            search(grid, mi, mj);
        }
    }

    @Test
    public void test() {

        Assert.assertEquals(1, numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));

        Assert.assertEquals(3, numIslands(new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}));

        System.out.println("ok");
    }
}
