package solutions.s6;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author weixun
 * @Date 2021-09-16
 * @See https://leetcode-cn.com/problems/zigzag-conversion/
 */
public class Solution {

    public String convert(String s, int numRows) {
        if(null == s || s.length() <= numRows || numRows < 2) {
            return s;
        }

        char[] sArray = s.toCharArray();
        StringBuilder[] buildMap = new StringBuilder[numRows];
        int period = 2 * numRows - 2;
        for (int i = 0; i < s.length(); i++) {
            int baseI = i % period;
            int rowI = baseI < numRows ? baseI : period - baseI;
            if(null == buildMap[rowI]) {
                buildMap[rowI] = new StringBuilder();
            }
            buildMap[rowI].append(sArray[i]);
        }

        StringBuilder targetS = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            targetS.append(buildMap[i].toString());
        }

        return targetS.toString();
    }

    @Test
    public void test() {
        Assert.assertEquals("PAHNAPLSIIGYIR", convert("PAYPALISHIRING", 3));

        Assert.assertEquals("PINALSIGYAHRPI", convert("PAYPALISHIRING", 4));

        Assert.assertEquals("A", convert("A", 1));

        Assert.assertEquals("AB", convert("AB", 1));

        System.out.println("ok");
    }
}
