package solutions.s143;

import base.ListNode;
import base.TreeNode;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 143. 重排链表
 * @Author weixun
 * @Date 2021-10-14
 * @See https://leetcode-cn.com/problems/reorder-list/
 */
public class Solution {

    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转中后部分链表
        ListNode tail = null;
        ListNode mid = slow.next;
        slow.next = null;
        while(mid != null) {
            ListNode tmp = mid.next;
            mid.next = tail;
            tail = mid;
            mid = tmp;
        }

        ListNode cur = head;
        while(cur != null && tail != null) {
            ListNode nxt = cur.next;
            cur.next = tail;
            ListNode tnx = tail.next;
            tail.next = nxt;
            cur = nxt;
            tail = tnx;
        }
    }

    @Test
    public void test() {

        ListNode node1 = ListNode.buildListNode(new int[]{1,2,3,4});
        reorderList(node1);
        ListNode.buildListNode(new int[]{1,4,2,3}).assertListNodeEquals(node1);

        ListNode node2 = ListNode.buildListNode(new int[]{1,2,3,4,5});
        reorderList(node2);
        ListNode.buildListNode(new int[]{1,5,2,4,3}).assertListNodeEquals(node2);

        System.out.println("ok");
    }
}
