package solutions.s9;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * @Author weixun
 * @Date 2021-09-18
 * @See https://leetcode-cn.com/problems/palindrome-number/
 */
public class Solution {

    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        if(x < 2) {
            return true;
        }
        HashMap<Integer, Integer> mp = new HashMap<>();
        int i = 0;
        while(x != 0) {
            mp.put(i, x % 10);
            x = x / 10;
            i++;
        }

        i--;
        for(int j = 0; j < i; j++,i--) {
            if(mp.get(j) != mp.get(i)) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void test() {
        Solution solution = new Solution();

        Assert.assertEquals(true, solution.isPalindrome(121));

        Assert.assertEquals(false, solution.isPalindrome(-121));

        Assert.assertEquals(false, solution.isPalindrome(10));

        Assert.assertEquals(false, solution.isPalindrome(-101));

        Assert.assertEquals(true, solution.isPalindrome(11));

        System.out.println("ok");
    }
}
