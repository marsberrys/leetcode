package solutions.s165;

import base.Node;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author weixun
 * @Date 2021-09-25
 * @See https://leetcode-cn.com/problems/compare-version-numbers/
 */
public class Solution {

    public int compareVersion(String version1, String version2) {
        String[] v1Nums = version1.split("\\.");
        String[] v2Nums = version2.split("\\.");

        for (int i = 0; i < v1Nums.length || i < v2Nums.length; i++) {
            int v1 = 0, v2 = 0;
            if(i < v1Nums.length) {
                v1 = Integer.valueOf(v1Nums[i]);
            }
            if(i < v2Nums.length) {
                v2 = Integer.valueOf(v2Nums[i]);
            }

            if(v1 < v2) {
                return -1;
            } else if(v1 > v2) {
                return 1;
            }
        }

        return 0;
    }

    @Test
    public void test() {
        Solution solution = new Solution();

        Assert.assertEquals(0, solution.compareVersion("1.01", "1.001"));

        Assert.assertEquals(0, solution.compareVersion("1.0", "1.0.0"));

        Assert.assertEquals(-1, solution.compareVersion("0.1", "1.1"));

        Assert.assertEquals(1, solution.compareVersion("1.0.1", "1"));

        Assert.assertEquals(-1, solution.compareVersion("7.5.2.4", "7.5.3"));

        System.out.println("ok");
    }
}
