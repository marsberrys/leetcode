package solutions.s160_s2297;

import base.ListNode;
import org.junit.Test;

/**
 * 160. 相交链表
 * 面试题 02.07. 链表相交
 * @Author weixun
 * @Date 2021-10-10
 * @See https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * @See https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }

        ListNode pa = headA, pb = headB;
        while(pa != pb) {
            if(pa == null) {
                pa = headB;
            } else {
                pa = pa.next;
            }
            if(pb == null) {
                pb = headA;
            } else {
                pb = pb.next;
            }
        }

        return pa;
    }

    @Test
    public void test() {

        System.out.println("ok");
    }
}
