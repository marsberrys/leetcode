package solutions.s148;

import base.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 148. 排序链表
 * @Author weixun
 * @Date 2021-11-16
 * @See https://leetcode-cn.com/problems/sort-list/
 */
public class Solution {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, quick = head.next;
        while(quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }

        ListNode part2 = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(part2));
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode np = new ListNode();
        ListNode cur = np;

        while(h1 != null && h2 != null) {
            if(h1.val <= h2.val) {
                cur.next = h1;
                h1 = h1.next;
            } else {
                cur.next = h2;
                h2 = h2.next;
            }
            cur = cur.next;
        }

        if(h1 != null) {
            cur.next = h1;
        }

        if(h2 != null) {
            cur.next = h2;
        }

        return np.next;
    }

    @Test
    public void test() {

        assert ListNode.buildListNode(new int[]{1,2,3,4}).assertListNodeEquals(sortList(ListNode.buildListNode(new int[]{4,2,1,3})));

        assert ListNode.buildListNode(new int[]{-1,0,3,4,5}).assertListNodeEquals(sortList(ListNode.buildListNode(new int[]{-1,5,3,4,0})));

        Assert.assertEquals(null, sortList(ListNode.buildListNode(new int[]{})));

        System.out.println("ok");
    }
}
