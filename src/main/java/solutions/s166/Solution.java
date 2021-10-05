package solutions.s166;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author weixun
 * @Date 2021-10-04
 * @See https://leetcode-cn.com/problems/fraction-to-recurring-decimal/
 */
public class Solution {

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            sb.append("-");
        }

        long numeratorLong = Math.abs(Long.valueOf(numerator));
        long denominatorLong = Math.abs(Long.valueOf(denominator));
        if(numeratorLong % denominatorLong == 0) {
            return sb.append(String.valueOf(numeratorLong / denominatorLong)).toString();
        }

        if(numeratorLong > denominatorLong) {
            sb.append(String.valueOf(numeratorLong / denominatorLong) + ".");
            numeratorLong = numeratorLong % denominatorLong;
        } else {
            sb.append("0.");
        }

        Map<Long, Integer> modMap = new HashMap<>();
        long remainder = numeratorLong % denominatorLong;
        while(remainder != 0 && null == modMap.get(remainder)) {
            modMap.put(remainder, sb.length());
            remainder *= 10;
            sb.append(String.valueOf(remainder / denominatorLong));
            remainder = remainder % denominatorLong;
        }

        if(remainder != 0) {
            sb.insert(modMap.get(remainder), "(");
            sb.append(")");
        }

        return sb.toString();
    }


    @Test
    public void test() {

        Assert.assertEquals("0.5", fractionToDecimal(1, 2));

        Assert.assertEquals("2", fractionToDecimal(2, 1));

        Assert.assertEquals("0.(6)", fractionToDecimal(2, 3));

        Assert.assertEquals("0.(012)", fractionToDecimal(4, 333));

        Assert.assertEquals("0.2", fractionToDecimal(1, 5));

        Assert.assertEquals("0", fractionToDecimal(0, 3));

        Assert.assertEquals("0.0000000004656612873077392578125", fractionToDecimal(-1, -2147483648));

        System.out.println("ok");
    }
}
