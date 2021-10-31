package solutions.s125;

import org.junit.Assert;
import org.junit.Test;

/**
 * 125. 验证回文串
 * @Author weixun
 * @Date 2021-10-20
 * @See https://leetcode-cn.com/problems/valid-palindrome/
 */
public class Solution {

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        s = s.toLowerCase();
        while(i < j) {
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    @Test
    public void test() {

        Assert.assertEquals(true, isPalindrome("A man, a plan, a canal: Panama"));

        Assert.assertEquals(false, isPalindrome("race a car"));


        System.out.println("ok");
    }
}
