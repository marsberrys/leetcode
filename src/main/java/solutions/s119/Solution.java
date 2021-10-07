package solutions.s119;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * @Author weixun
 * @Date 2021-10-07
 * @See https://leetcode-cn.com/problems/pascals-triangle-ii/
 */
public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);

        for(int i = 1; i<= rowIndex; i++) {
            res.add(1);
            for(int j = i - 1; j > 0; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }

        return res;
    }

    @Test
    public void test() {

        Arrays.asList(1,3,3,1).equals(getRow(3));

        Arrays.asList(1).equals(getRow(0));

        Arrays.asList(1,1).equals(getRow(1));

        System.out.println("ok");
    }
}
