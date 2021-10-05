package solutions.s470;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author weixun
 * @Date 2021-10-01
 * @See https://leetcode-cn.com/problems/implement-rand10-using-rand7/
 */
public class Solution {

    public int rand10() {
        while(true) {
            int rand = (rand7() - 1) * 7 + (rand7() - 1);
            if(rand < 40) {
                return rand % 10 + 1;
            }
        }
    }

    private int rand7() {
        return (int)(Math.random() * 6 + 1);
    }


    @Test
    public void test() {

        System.out.println(rand7());
        System.out.println(rand7());
        System.out.println(rand7());
        System.out.println(rand7());
        System.out.println(rand7());

        System.out.println("ok");
    }

}
