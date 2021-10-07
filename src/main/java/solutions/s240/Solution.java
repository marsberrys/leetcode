package solutions.s240;

import org.junit.Assert;
import org.junit.Test;

/**
 * 240. 搜索二维矩阵 II
 * @Author weixun
 * @Date 2021-10-05
 * @See https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1) {
            return false;
        }

        int h = matrix.length, w = matrix[0].length;
        int col = 0, row = h - 1;

        while(col < w && row >= 0) {
            if(matrix[row][col] == target) {
                return true;
            }
            if(matrix[row][col] > target) {
                row--;
            } else {
                col++;
            }
        }

        return false;
    }


    @Test
    public void test() {

        Assert.assertEquals(true, searchMatrix(new int[][]{
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        }, 5));

        Assert.assertEquals(false, searchMatrix(new int[][]{
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        }, 20));

        System.out.println("ok");
    }
}
