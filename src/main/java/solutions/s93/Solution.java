package solutions.s93;

import base.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 93. 复原 IP 地址
 * @Author weixun
 * @Date 2021-11-5
 * @See https://leetcode-cn.com/problems/restore-ip-addresses/
 */
public class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12) {
            return ans;
        }

        List<String> parts = new ArrayList<>();
        dfs(ans, s.toCharArray(), parts, 0);
        return ans;
    }

    private void dfs(List<String> ans, char[] sArr, List<String> parts, int idx) {
        if((idx != sArr.length && parts.size() == 4) || (idx == sArr.length && parts.size() != 4)) {
            return;
        }

        if(parts.size() == 4 && idx == sArr.length) {
            ans.add(parts.stream().collect(Collectors.joining(".")));
            return;
        }

        if(sArr[idx] == '0') {
            parts.add("0");
            dfs(ans, sArr, parts, idx + 1);
            parts.remove(parts.size() - 1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        while(idx < sArr.length && parts.size() < 4) {
            sb.append(sArr[idx]);
            String part = sb.toString();
            if(Integer.valueOf(part) <= 255) {
                parts.add(part);
                dfs(ans, sArr, parts, idx + 1);
                parts.remove(parts.size() - 1);
            } else {
                break;
            }
            idx++;
        }
    }

    @Test
    public void test() {

        assert Arrays.asList("255.255.11.135","255.255.111.35").equals(restoreIpAddresses("25525511135"));

        assert Arrays.asList("0.10.0.10","0.100.1.0").equals(restoreIpAddresses("010010"));

        assert Arrays.asList("0.0.0.0").equals(restoreIpAddresses("0000"));

        assert Arrays.asList("1.1.1.1").equals(restoreIpAddresses("1111"));

        assert Arrays.asList("1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3").equals(restoreIpAddresses("101023"));

        System.out.println("ok");
    }
}
