package solutions.s206;

import base.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author weixun
 * @Date 2021-09-30
 * @See https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode prev = head, cursor = head.next;
        while(cursor != null) {
            ListNode tmp = cursor.next;
            cursor.next = prev;
            prev = cursor;
            cursor = tmp;
        }

        head.next = null;
        return prev;
    }

    @Test
    public void test() {

        reverseList(ListNode.buildListNodeWithNums(new int[]{1,2,3,4,5})).assertListNodeEquals(new int[]{5,4,3,2,1});

        reverseList(ListNode.buildListNodeWithNums(new int[]{1,2})).assertListNodeEquals(new int[]{2,1});

        ListNode.assertTowListNode(reverseList(ListNode.buildListNodeWithNums(new int[]{})), ListNode.buildListNodeWithNums(new int[]{}));

        System.out.println("ok");
    }
}
