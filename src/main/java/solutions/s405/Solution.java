package solutions.s405;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * @Author weixun
 * @Date 2021-10-02
 * @See https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/
 */
public class Solution {

    public String toHex(int num) {
        if(num == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        while(num != 0) {
            int c = num & 15;
            sb.append(c < 10 ? (char)(c + '0') : (char)(c - 10 + 'a'));
            num >>>= 4;
        }

        return sb.reverse().toString();
    }

    @Test
    public void test() {

        Assert.assertEquals("1a", toHex(26));

        Assert.assertEquals("ffffffff", toHex(-1));

        System.out.println("ok");
    }
}
