package solutions.s147;

import base.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 147. 对链表进行插入排序
 * @Author weixun
 * @Date 2021-11-16
 * @See https://leetcode-cn.com/problems/insertion-sort-list/
 */
public class Solution {

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode np = new ListNode();
        ListNode cur, p = head;
        while(p != null) {
            cur = np;
            while(cur.next != null && cur.next.val < p.val) {
                cur = cur.next;
            }

            ListNode tmp = p.next;
            p.next = cur.next;
            cur.next = p;
            p = tmp;
        }

        return np.next;
    }

    @Test
    public void test() {

        assert ListNode.buildListNode(new int[]{1,2,3,4}).assertListNodeEquals(insertionSortList(ListNode.buildListNode(new int[]{4,2,1,3})));

        assert ListNode.buildListNode(new int[]{-1,0,3,4,5}).assertListNodeEquals(insertionSortList(ListNode.buildListNode(new int[]{-1,5,3,4,0})));

        System.out.println("ok");
    }
}
