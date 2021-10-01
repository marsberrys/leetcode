package solutions.s25;

import base.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @Author weixun
 * @Date 2021-09-30
 * @See https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1) {
            return head;
        }

        ListNode cur = head, groupHead = head, prev = null;
        int counter1 = 1;
        while(cur != null) {
            if(counter1 % k == 0) {
                int counter2 = k;

                ListNode groupHeadPrev = groupHead, newGroupTail = groupHead;
                groupHead = groupHead.next;
                while(--counter2 > 0) {
                    ListNode tmp = groupHead.next;
                    groupHead.next = groupHeadPrev;
                    groupHeadPrev = groupHead;
                    groupHead = tmp;
                }

                if(counter1 == k) {
                    head = groupHeadPrev;
                }

                newGroupTail.next = groupHead;
                cur = groupHead;
                if(null != prev) {
                    prev.next = groupHeadPrev;
                }
                prev = newGroupTail;
            } else {
                cur = cur.next;
            }
            counter1++;
        }

        return head;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        if(k <= 1) {
            return head;
        }

        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        while(null != head) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if(tail == null) {
                    return hair.next;
                }
            }

            // reverse head to tail
            ListNode tailNext = tail.next;
            ListNode[] reverseGroup = reverseGroup(head, tail);

            pre.next =  reverseGroup[0];
            reverseGroup[1].next = tailNext;

            pre = reverseGroup[1];
            head = tailNext;
        }

        return hair.next;
    }

    private ListNode[] reverseGroup(ListNode head, ListNode tail) {
        ListNode prev = tail.next, cur = head;
        while(prev != tail) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }

        return new ListNode[]{tail, head};
    }


    @Test
    public void test() {

        assert ListNode.buildListNodeWithNums(new int[]{2,1,4,3,5}).assertListNodeEquals(reverseKGroup(ListNode.buildListNodeWithNums(new int[]{1,2,3,4,5}), 2));

        assert ListNode.buildListNodeWithNums(new int[]{3,2,1,4,5}).assertListNodeEquals(reverseKGroup(ListNode.buildListNodeWithNums(new int[]{1,2,3,4,5}), 3));

        assert ListNode.buildListNodeWithNums(new int[]{1,2,3,4,5}).assertListNodeEquals(reverseKGroup(ListNode.buildListNodeWithNums(new int[]{1,2,3,4,5}), 1));

        assert ListNode.buildListNodeWithNums(new int[]{1}).assertListNodeEquals(reverseKGroup(ListNode.buildListNodeWithNums(new int[]{1}), 1));

        assert ListNode.buildListNodeWithNums(new int[]{2,1,4,3,5}).assertListNodeEquals(reverseKGroup2(ListNode.buildListNodeWithNums(new int[]{1,2,3,4,5}), 2));

        assert ListNode.buildListNodeWithNums(new int[]{3,2,1,4,5}).assertListNodeEquals(reverseKGroup2(ListNode.buildListNodeWithNums(new int[]{1,2,3,4,5}), 3));

        assert ListNode.buildListNodeWithNums(new int[]{1,2,3,4,5}).assertListNodeEquals(reverseKGroup2(ListNode.buildListNodeWithNums(new int[]{1,2,3,4,5}), 1));

        assert ListNode.buildListNodeWithNums(new int[]{1}).assertListNodeEquals(reverseKGroup2(ListNode.buildListNodeWithNums(new int[]{1}), 1));

        System.out.println("ok");
    }
}
