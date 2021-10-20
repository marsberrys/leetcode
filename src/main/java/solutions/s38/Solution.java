package solutions.s38;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;


/**
 * 38. 外观数列
 * @Author weixun
 * @Date 2021-10-18
 * @See https://leetcode-cn.com/problems/count-and-say/
 */
public class Solution {

    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }

        String sub = countAndSay(n - 1);
        char[] subChars = sub.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < sub.length()) {
            int k = 1;
            char ch = subChars[i];
            while(i + k < sub.length() && ch == subChars[i + k]) {
                k++;
            }
            sb.append(k);
            sb.append(ch);
            i += k;
        }

        return sb.toString();
    }

    @Test
    public void test() {

        Assert.assertEquals("1", countAndSay(1));

        Assert.assertEquals("1211", countAndSay(4));

        System.out.println("ok");
    }
}
