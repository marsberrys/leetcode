package solutions.s583;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author weixun
 * @Date 2021-09-25
 * @See https://leetcode-cn.com/problems/delete-operation-for-two-strings/
 */
public class Solution {

    public int minDistance(String word1, String word2) {
        return -1;
    }


    @Test
    public void test() {
        Solution solution = new Solution();

        Assert.assertEquals(0, solution.minDistance("1.01", "1.001"));

        System.out.println("ok");
    }
}
