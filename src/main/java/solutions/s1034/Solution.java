package solutions.s1034;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 1034. 边界着色
 * @Author weixun
 * @Date 2021-12-08
 * @See https://leetcode-cn.com/problems/coloring-a-border/
 */
public class Solution {

    private static int[][] trace = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int rows = grid.length, cols = grid[0].length;
        if(row < 0 || col < 0 || row >= rows || col >= cols) {
            return grid;
        }

        List<int[]> border = new ArrayList<>();
        boolean[][] visited = new boolean[rows][cols];
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{row, col});
        visited[row][col] = true;
        while(!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0], l = node[1];
            boolean isBorder = false;
            for(int i = 0; i < trace.length; i++) {
                int nr = node[0] + trace[i][0];
                int nl = node[1] + trace[i][1];

                if (nr < 0 || nr >= rows || nl < 0 || nl >= cols || grid[nr][nl] != grid[r][l]) {
                    isBorder = true;
                    continue;
                }

                if (!visited[nr][nl]) {
                    q.offer(new int[]{nr, nl});
                    visited[nr][nl] = true;
                }
            }

            if(isBorder) {
                border.add(new int[]{r,l});
            }
        }

        for(int[] n : border) {
            grid[n[0]][n[1]] = color;
        }

        return grid;
    }

    @Test
    public void test() {

        Assert.assertArrayEquals(new int[][]{{2,2,2},{2,1,2},{2,2,2}}, colorBorder(new int[][]{{1,1,1},{1,1,1},{1,1,1}}, 1, 1, 2));

        Assert.assertArrayEquals(new int[][]{{3,3},{3,2}}, colorBorder(new int[][]{{1,1},{1,2}}, 0, 0, 3));

        System.out.println("ok");
    }
}
