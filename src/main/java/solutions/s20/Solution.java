package solutions.s20;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 20. 有效的括号
 * @Author weixun
 * @Date 2021-10-07
 * @See https://leetcode-cn.com/problems/valid-parentheses/
 */
public class Solution {

    public boolean isValid(String s) {
        Map<Character, Character> symbolMap = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        ArrayList<Character> stack = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            switch(ch) {
                case ')':
                case '}':
                case ']':
                    if(stack.size() <= 0 || stack.get(stack.size() - 1) != symbolMap.get(ch)) {
                        return false;
                    }
                    stack.remove(stack.size() - 1);
                    break;
                default:
                    stack.add(ch);
                    break;
            }
        }

        return stack.size() <= 0;
    }


    @Test
    public void test() {

        Assert.assertEquals(true, isValid("()"));

        Assert.assertEquals(true, isValid("()[]{}"));

        Assert.assertEquals(false, isValid("(]"));

        Assert.assertEquals(false, isValid("([)]"));

        Assert.assertEquals(true, isValid("{[]}"));

        System.out.println("ok");
    }
}
