package solutions.s273;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 273. 整数转换英文表示
 * @Author weixun
 * @Date 2021-10-11
 * @See https://leetcode-cn.com/problems/integer-to-english-words/
 */
public class Solution {

    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 3, unit = 1000000000; i >= 0; i--, unit /= 1000) {
            int curNum = num / unit;
            if (curNum != 0) {
                num -= curNum * unit;
                StringBuffer curr = new StringBuffer();
                recursion(curr, curNum);
                curr.append(thousands[i]).append(" ");
                sb.append(curr);
            }
        }
        return sb.toString().trim();
    }

    public void recursion(StringBuffer curr, int num) {
        if (num == 0) {
            return;
        } else if (num < 10) {
            curr.append(singles[num]).append(" ");
        } else if (num < 20) {
            curr.append(teens[num - 10]).append(" ");
        } else if (num < 100) {
            curr.append(tens[num / 10]).append(" ");
            recursion(curr, num % 10);
        } else {
            curr.append(singles[num / 100]).append(" Hundred ");
            recursion(curr, num % 100);
        }
    }


    @Test
    public void test() {

        Assert.assertEquals("Zero", numberToWords(0));

        Assert.assertEquals("One Hundred Twenty Three", numberToWords(123));

        Assert.assertEquals("Twelve Thousand Three Hundred Forty Five", numberToWords(12345));

        Assert.assertEquals("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven", numberToWords(1234567));

        Assert.assertEquals("One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One", numberToWords(1234567891));

        System.out.println("ok");
    }
}
