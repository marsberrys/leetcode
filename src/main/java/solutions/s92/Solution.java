package solutions.s92;

import base.ListNode;
import base.TreeNode;
import org.junit.Test;


/**
 * 92. 反转链表 II
 * @Author weixun
 * @Date 2021-10-13
 * @See https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null) {
            return head;
        }
        if(left == right) {
            return head;
        }

        ListNode h = new ListNode(), tail;
        h.next = head;
        ListNode leftP = h, rightP = head;
        int cnt = 1;
        while(rightP != null && cnt < right) {
            if(cnt < left) {
                leftP = rightP;
            }
            rightP = rightP.next;
            cnt ++;
        }

        tail = rightP.next;
        rightP.next = null;
        ListNode subHead = leftP.next;
        leftP.next = reverseListNode(subHead);
        subHead.next = tail;

        return h.next;
    }

    private ListNode reverseListNode(ListNode head) {
        ListNode tail = null, cur = head;
        while(cur != null) {
            ListNode tmp = cur.next;
            cur.next = tail;
            tail = cur;
            cur = tmp;
        }

        return tail;
    }

    @Test
    public void test() {

        assert ListNode.buildListNode(new int[]{1,4,3,2,5}).assertListNodeEquals(reverseBetween(ListNode.buildListNode(new int[]{1,2,3,4,5}), 2, 4));

        assert ListNode.buildListNode(new int[]{5}).assertListNodeEquals(reverseBetween(ListNode.buildListNode(new int[]{5}), 1, 1));

        assert ListNode.buildListNode(new int[]{5,3}).assertListNodeEquals(reverseBetween(ListNode.buildListNode(new int[]{3,5}), 1, 2));

        System.out.println("ok");
    }
}
