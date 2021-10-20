package solutions.s67;

import org.junit.Assert;
import org.junit.Test;


/**
 * 67. 二进制求和
 * @Author weixun
 * @Date 2021-10-19
 * @See https://leetcode-cn.com/problems/add-binary/
 */
public class Solution {

    public String addBinary(String a, String b) {
        int over = 0;
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        int i = a.length() - 1, j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0) {
            int atmp = i >= 0 ? Integer.valueOf(aChars[i]) - '0' : 0;
            int btmp = j >= 0 ? Integer.valueOf(bChars[j]) - '0' : 0;

            sb.insert(0, atmp ^ btmp ^ over);
            over = atmp + btmp + over >= 2 ? 1 : 0;
            i--;
            j--;
        }

        if(over > 0) {
            sb.insert(0, '1');
        }

        return sb.toString();
    }

    @Test
    public void test() {
        int n = 15;
        System.out.println(n & 1);
        System.out.println(n);
        Assert.assertEquals("100", addBinary("11", "1"));

        Assert.assertEquals("10101", addBinary("1010", "1011"));

        System.out.println("ok");
    }
}
