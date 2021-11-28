package solutions.s19;

import base.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 19. 删除链表的倒数第 N 个结点
 * @Author weixun
 * @Date 2021-11-28
 * @See https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return head;
        }
        ListNode lp, rp = new ListNode();
        rp.next = head;
        lp = rp;
        int k = 0;
        while(rp != null && rp.next != null) {
            rp = rp.next;
            k++;
            if(k > n) {
                lp = lp.next;
                k--;
            }
        }

        if(k < n) {
            return head;
        } else {
            if(lp.next == head) {
                return lp.next.next;
            }

            lp.next = lp.next.next;
        }

        return head;
    }


    @Test
    public void test() {

        assert ListNode.buildListNode(new int[]{1,2,3,5}).assertListNodeEquals(removeNthFromEnd(ListNode.buildListNode(new int[]{1,2,3,4,5}), 2));

        assert ListNode.buildListNode(new int[]{1}).assertListNodeEquals(removeNthFromEnd(ListNode.buildListNode(new int[]{1,2}), 1));

        Assert.assertEquals(null, removeNthFromEnd(ListNode.buildListNode(new int[]{1}), 1));

        System.out.println("ok");
    }
}
