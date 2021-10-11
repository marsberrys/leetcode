package solutions.s232;

import base.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 234. 回文链表
 * @Author weixun
 * @Date 2021-10-10
 * @See https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        ListNode cur = head;
        while(cur != null) {
            vals.add(cur.val);
            cur = cur.next;
        }

        int i = 0, j = vals.size() - 1;
        while(i < j) {
            if(vals.get(i) != vals.get(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    @Test
    public void test() {

        Assert.assertEquals(true, isPalindrome(ListNode.buildListNode(new int[]{1,2,2,1})));

        Assert.assertEquals(false, isPalindrome(ListNode.buildListNode(new int[]{1,2})));

        System.out.println("ok");
    }
}
