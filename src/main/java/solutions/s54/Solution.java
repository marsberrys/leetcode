package solutions.s54;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * @Author weixun
 * @Date 2021-10-07
 * @See https://leetcode-cn.com/problems/spiral-matrix/
 */
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(null == matrix || matrix.length < 1 || matrix[0].length < 1) {
            return res;
        }
        int bottom = matrix.length - 1, right = matrix[0].length - 1, top = 0, left = 0;
        while(top <= bottom && left <= right) {
            for (int col = left; col <= right; col++) {
                res.add(matrix[top][col]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }
            if(left < right && top < bottom) {
                for(int col = right - 1; col >= left; col--) {
                    res.add(matrix[bottom][col]);
                }
                for(int row = bottom - 1; row > top; row--) {
                    res.add(matrix[row][left]);
                }
            }
            left++;
            top++;
            right--;
            bottom--;
        }

        return res;
    }

    @Test
    public void test() {

        assert Arrays.asList(1,2,3,6,9,8,7,4,5).equals(spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));

        assert Arrays.asList(1,2,3,4,8,12,11,10,9,5,6,7).equals(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));

        assert Arrays.asList(1,2,3,4,8,12,11,10,9,5,6,7).equals(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));

        assert Arrays.asList(1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10).equals(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}));

        System.out.println("ok");
    }
}
