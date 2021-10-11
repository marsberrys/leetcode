package solutions.s2104;

import base.ListNode;
import org.junit.Assert;
import org.junit.Test;


/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * @Author weixun
 * @Date 2021-10-10
 * @See https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class Solution {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode prevK = head, cur = head;
        int cnt = 0;

        while(cur != null) {
            cur = cur.next;
            cnt++;
            if(cnt > k) {
                prevK = prevK.next;
            }
        }

        return prevK;
    }

    @Test
    public void test() {

        System.out.println("ok");
    }
}
