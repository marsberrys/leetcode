package solutions.s326;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author weixun
 * @Date 2021-09-23
 * @See https://leetcode-cn.com/problems/power-of-three/
 */
public class Solution {

    public boolean isPowerOfThree(int n) {
        if(n <= 0) {
            return false;
        }

        while(n > 1) {
            if(n % 3 != 0) {
                return false;
            }
            n /= 3;
        }

        return true;
    }

    private boolean isCharMatch(char sChar, char pChar) {
        return sChar == pChar || pChar == '.';
    }

    @Test
    public void test() {

        Assert.assertEquals(true, isPowerOfThree(27));

        Assert.assertEquals(false, isPowerOfThree(0));

        Assert.assertEquals(true, isPowerOfThree(9));

        Assert.assertEquals(false, isPowerOfThree(45));

        System.out.println("ok");
    }
}
