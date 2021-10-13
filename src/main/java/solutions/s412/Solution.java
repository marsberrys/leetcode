package solutions.s412;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 412. Fizz Buzz
 * @Author weixun
 * @Date 2021-10-13
 * @See https://leetcode-cn.com/problems/fizz-buzz/
 */
public class Solution {

    public List<String> fizzBuzz(int n) {

        List<String> res = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(i % 15 == 0) {
                res.add("FizzBuzz");
            } else if(i % 5 == 0) {
                res.add("Buzz");
            } else if(i % 3 == 0) {
                res.add("Fizz");
            } else {
                res.add(String.valueOf(i));
            }
        }

        return res;
    }

    @Test
    public void test() {

        assert Arrays.asList("1","2","Fizz").equals(fizzBuzz(3));

        assert Arrays.asList("1","2","Fizz","4","Buzz").equals(fizzBuzz(5));

        assert Arrays.asList("1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz").equals(fizzBuzz(15));

        System.out.println("ok");
    }
}
