package solutions.s394;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 394. 字符串解码
 * @Author weixun
 * @Date 2021-11-25
 * @See https://leetcode-cn.com/problems/decode-string/
 */
public class Solution {

    public String decodeString(String s) {
        int len = s.length();
        char[] chs = s.toCharArray();
        Deque<Integer> stackNum = new LinkedList<>();
        Deque<String> stackChar = new LinkedList<>();

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < len) {
            if(Character.isDigit(chs[i])) {
                sb.append(chs[i]);
            } else if(chs[i] == '[') {
                stackChar.push("[");
                stackNum.push(Integer.valueOf(sb.toString()));
                sb.delete(0, sb.length());
            } else if(chs[i] == ']') {
                // "]"
                int times = stackNum.pop();
                String subS = stackChar.pop();
                String result = "";
                for(int k = 0; k < times; k++) {
                    result += subS;
                }

                while(!stackChar.isEmpty()) {
                    String prev = stackChar.pop();
                    if("[".equals(prev)) {
                        break;
                    }
                    result = prev + result;
                }

                stackChar.push(result);
                i++;
            } else {
                sb.append(chs[i]);
            }
            i++;
        }

        String result = "";
        while(!stackChar.isEmpty()) {
            result = stackChar.pop() + result;
        }


        return result;
    }


    @Test
    public void test() {

        Assert.assertEquals("aaabcbc", decodeString("3[a]2[bc]"));

        Assert.assertEquals("accaccacc", decodeString("3[a2[c]]"));

        Assert.assertEquals("abcabccdcdcdef", decodeString("2[abc]3[cd]ef"));

        Assert.assertEquals("abccdcdcdxyz", decodeString("abc3[cd]xyz"));

        System.out.println("ok");
    }
}
