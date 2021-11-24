package solutions.s43;

import org.junit.Assert;
import org.junit.Test;

/**
 * 43. 字符串相乘
 * @Author weixun
 * @Date 2021-11-24
 * @See https://leetcode-cn.com/problems/multiply-strings/
 */
public class Solution {

    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        if("1".equals(num1)) {
            return num2;
        }
        if("1".equals(num2)) {
            return num1;
        }
        char[] nums1 = num1.toCharArray(), nums2 = num2.toCharArray();
        int n1 = num1.length(), n2 = num2.length();

        int[] result = new int[n1 + n2];
        for(int i = n2 - 1; i >= 0; i--) {
            int[] subM = subMultiply(nums1, nums2[i]);
            for(int k = 0; k < subM.length; k++) {
                int bitTmp = result[n1 - k + i] + subM[subM.length - k - 1];
                if(bitTmp >= 10) {
                    result[n1 - k + i - 1] = result[n1 - k + i - 1] + bitTmp / 10;
                }
                result[n1 - k + i] = bitTmp % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int r = 0; r < result.length; r++) {
            sb.append(result[r]);
        }

        return sb.toString().replaceAll("^0+", "");
    }

    private int[] subMultiply(char[] chs, char ch) {
        int len = chs.length;
        if(ch == '0' || len == 0 || (len == 1 && chs[0] == '0')) {
            return new int[]{0};
        }

        int[] result = new int[len + 1];
        int i = len;
        int chNu = ch - '0';
        while(i > 0) {
            int tmp = (chs[i - 1] - '0') * chNu;
            if(tmp >= 10) {
                result[i - 1] = tmp / 10;
            }
            result[i] = result[i] + tmp % 10;
            i--;
        }

        return result;
    }


    @Test
    public void test() {

        Assert.assertEquals("56088", multiply("123", "456"));

        Assert.assertEquals("6", multiply("2", "3"));

        System.out.println("ok");
    }
}
