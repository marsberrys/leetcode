package solutions.s14;

import org.junit.Assert;
import org.junit.Test;


/**
 * 14. 最长公共前缀
 * @Author weixun
 * @Date 2021-10-10
 * @See https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        String maxS = "";
        if(strs.length == 0) {
            return maxS;
        }
        if(strs.length < 2) {
            return strs[0];
        }

        for(int i = 0; i < strs[0].length(); i++){
            for(int j = 0; j < strs.length - 1; j++) {
                if(i >= strs[j].length() || i >= strs[j + 1].length()) {
                    return maxS;
                }
                if(strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                    return maxS;
                }
            }
            maxS += strs[0].charAt(i);
        }

        return maxS;
    }

    @Test
    public void test() {

        Assert.assertEquals("fl", longestCommonPrefix(new String[]{"flower","flow","flight"}));

        Assert.assertEquals("", longestCommonPrefix(new String[]{"dog","racecar","car"}));

        System.out.println("ok");
    }
}
