package solutions.s434;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 434. 字符串中的单词数
 * @Author weixun
 * @Date 2021-10-07
 * @See https://leetcode-cn.com/problems/number-of-segments-in-a-string/
 */
public class Solution {

    public int countSegments(String s) {
        if(null == s || "".equals(s)) {
            return 0;
        }

        char[] sChars = s.toCharArray();
        int count = 0;
        for(int i = 0; i < sChars.length; i++) {
            if(sChars[i] != ' ' && (i == 0 || sChars[i - 1] == ' ')) {
                count++;
            }
        }

        return count;
    }


    @Test
    public void test() {

        Assert.assertEquals(5, countSegments("Hello, my name is John"));

        Assert.assertEquals(1, countSegments("a"));

        System.out.println("ok");
    }
}
