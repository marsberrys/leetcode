package solutions.s24;

import base.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 24. 两两交换链表中的节点
 * @Author weixun
 * @Date 2021-11-16
 * @See https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode np = new ListNode();
        np.next = head;
        ListNode cur = np;
        while(cur.next != null && cur.next.next != null) {
            ListNode nnxt = cur.next.next;
            ListNode tmp = nnxt.next;
            nnxt.next = cur.next;
            cur.next.next = tmp;
            cur.next = nnxt;
            cur = cur.next.next;
        }

        return np.next;
    }

    @Test
    public void test() {

        assert ListNode.buildListNode(new int[]{2,1,4,3}).assertListNodeEquals(swapPairs(ListNode.buildListNode(new int[]{1,2,3,4})));

        assert ListNode.buildListNode(new int[]{1}).assertListNodeEquals(swapPairs(ListNode.buildListNode(new int[]{1})));

        Assert.assertEquals(null, swapPairs(ListNode.buildListNode(new int[]{})));

        System.out.println("ok");
    }
}
