package solutions.s476_s1009;

import org.junit.Assert;
import org.junit.Test;

/**
 * 476. 数字的补数
 * @Author weixun
 * @Date 2021-10-18
 * @See https://leetcode-cn.com/problems/number-complement/
 */
public class Solution {

    public int findComplement(int num) {
        if(num == 0) {
            return 1;
        }
        int oNum = num;
        int k = 0;
        while (num > 0) {
            num >>= 1;
            k++;
        }
        int mark = k == 31 ? 0x7fffffff : (1 << k) - 1;
        return oNum ^ mark;
    }

    @Test
    public void test() {

        Assert.assertEquals(2, findComplement(5));

        Assert.assertEquals(0, findComplement(1));

        Assert.assertEquals(1, findComplement(0));

        Assert.assertEquals(320204598, findComplement(753537225));

        System.out.println("ok");
    }
}
