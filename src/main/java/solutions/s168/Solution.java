package solutions.s168;

import org.junit.Assert;
import org.junit.Test;


/**
 * 168. Excel表列名称
 * @Author weixun
 * @Date 2021-10-23
 * @See https://leetcode-cn.com/problems/excel-sheet-column-title/
 */
public class Solution {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while(columnNumber > 0) {
            columnNumber--;
            int m = columnNumber % 26;
            columnNumber /= 26;
            sb.append((char)('A' + m));
        }

        return sb.reverse().toString();
    }


    @Test
    public void test() {

        Assert.assertEquals("A", convertToTitle(1));

        Assert.assertEquals("ZY", convertToTitle(701));

        Assert.assertEquals("AB", convertToTitle(28));

        Assert.assertEquals("FXSHRXW", convertToTitle(2147483647));

        System.out.println("ok");
    }
}
