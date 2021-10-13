package solutions.s83;

import base.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 83. 删除排序链表中的重复元素
 * @Author weixun
 * @Date 2021-10-12
 * @See https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;

        while(cur != null) {
            if(null != cur.next && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }


    @Test
    public void test() {

        Assert.assertEquals(null, deleteDuplicates(ListNode.buildListNode(new int[]{})));

        assert ListNode.buildListNode(new int[]{1,2}).assertListNodeEquals(deleteDuplicates(ListNode.buildListNode(new int[]{1,1,2})));

        assert ListNode.buildListNode(new int[]{1,2,3}).assertListNodeEquals(deleteDuplicates(ListNode.buildListNode(new int[]{1,1,2,3,3})));

        System.out.println("ok");
    }
}
