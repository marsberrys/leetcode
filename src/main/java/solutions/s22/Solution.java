package solutions.s22;

import base.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 22. 括号生成
 * @Author weixun
 * @Date 2021-10-31
 * @See https://leetcode-cn.com/problems/generate-parentheses/
 */
public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        gen(ans, n, 0, 0, new StringBuilder());
        return ans;
    }

    private void gen(List<String> ans, int n, int open, int close, StringBuilder sb) {
        if(sb.length() >= n * 2) {
            ans.add(sb.toString());
        }

        if(open < n) {
            sb.append('(');
            gen(ans, n, open + 1, close, sb);
            sb.delete(sb.length() - 1, sb.length());
        }

        if(close < open) {
            sb.append(')');
            gen(ans, n, open, close + 1, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
    }

    @Test
    public void test() {

        assert Arrays.asList("((()))","(()())","(())()","()(())","()()()").equals(generateParenthesis(3));

        assert Arrays.asList("()").equals(generateParenthesis(1));

        System.out.println("ok");
    }
}
