package solutions.s171;

import base.TreeNode;
import org.junit.Assert;
import org.junit.Test;


/**
 * 171. Excel 表列序号
 * @Author weixun
 * @Date 2021-10-23
 * @See https://leetcode-cn.com/problems/excel-sheet-column-number/
 */
public class Solution {

    public int titleToNumber(String columnTitle) {
        int res = 0;
        char[] chars = columnTitle.toCharArray();
        int p = 0;
        while(p < columnTitle.length()) {
            res = res * 26 + (chars[p] - 'A' + 1);
            p++;
        }

        return res;
    }


    @Test
    public void test() {

        Assert.assertEquals(1, titleToNumber("A"));

        Assert.assertEquals(28, titleToNumber("AB"));

        Assert.assertEquals(701, titleToNumber("ZY"));

        Assert.assertEquals(2147483647, titleToNumber("FXSHRXW"));

        System.out.println("ok");
    }
}
