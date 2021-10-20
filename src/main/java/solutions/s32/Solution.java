package solutions.s32;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;


/**
 * 32. 最长有效括号
 * @Author weixun
 * @Date 2021-10-14
 * @See https://leetcode-cn.com/problems/longest-valid-parentheses/
 */
public class Solution {

    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int max = 0;
        char[] sChars = s.toCharArray();
        stack.push(-1);
        for(int i = 0; i < sChars.length; i++) {
            if(sChars[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;
    }

    @Test
    public void test() {

        Assert.assertEquals(2, longestValidParentheses("(()"));

        Assert.assertEquals(4, longestValidParentheses(")()())"));

        Assert.assertEquals(0, longestValidParentheses(""));

        System.out.println("ok");
    }
}
