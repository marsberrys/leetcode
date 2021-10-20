package solutions.s21_s2120;

import base.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 21. 合并两个有序链表
 * 剑指 Offer 25. 合并两个排序的链表
 * @Author weixun
 * @Date 2021-10-19
 * @See https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @See https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        ListNode p1 = l1, p2 = l2, head = new ListNode();
        ListNode cur = head;
        while(p1 != null || p2 != null) {
            if(p1 == null) {
                cur.next = p2;
                break;
            }
            if(p2 == null) {
                cur.next = p1;
                break;
            }

            if(p1.val <= p2.val) {
                cur.next = p1;
                p1 = p1.next;
                cur = cur.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
                cur = cur.next;
            }
        }

        return head.next;
    }


    @Test
    public void test() {

        assert ListNode.buildListNode(new int[]{1,1,2,3,4,4}).assertListNodeEquals(mergeTwoLists(
                ListNode.buildListNode(new int[]{1,2,4}),
                ListNode.buildListNode(new int[]{1,3,4})
        ));

        Assert.assertEquals(null, mergeTwoLists(
                ListNode.buildListNode(new int[]{}),
                ListNode.buildListNode(new int[]{})
        ));

        assert ListNode.buildListNode(new int[]{0}).assertListNodeEquals(mergeTwoLists(
                ListNode.buildListNode(new int[]{}),
                ListNode.buildListNode(new int[]{0})
        ));

        System.out.println("ok");
    }
}
