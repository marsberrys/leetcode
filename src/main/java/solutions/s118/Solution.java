package solutions.s118;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 118. 杨辉三角
 * @Author weixun
 * @Date 2021-10-06
 * @See https://leetcode-cn.com/problems/pascals-triangle/
 */
public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < numRows; i++) {
            List<Integer> levelRes = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    levelRes.add(1);
                } else {
                    levelRes.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }

            res.add(levelRes);
        }

        return res;
    }

    @Test
    public void test() {

        assert Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(1,1),
                Arrays.asList(1,2,1),
                Arrays.asList(1,3,3,1),
                Arrays.asList(1,4,6,4,1)
        ).equals(generate(5));

        assert Arrays.asList(
                Arrays.asList(1)
        ).equals(generate(1));


        System.out.println("ok");
    }
}
