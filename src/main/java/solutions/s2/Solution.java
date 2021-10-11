package solutions.s2;

import base.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author weixun
 * @Date 2021-09-13
 * @See https://leetcode-cn.com/problems/add-two-numbers/
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode current = result;
        int over = 0;
        current.val = over;
        while(null != l1 || null != l2) {
            int n1 = 0, n2 = 0;
            if(null != l1) {
                n1 = l1.val;
                l1 = l1.next;
            }
            if(null != l2) {
                n2 = l2.val;
                l2 = l2.next;
            }
            int sum = n1 + n2 + over;
            over = sum / 10;
            current.val = sum % 10;
            if(over > 0 || l1 != null || l2 != null) {
                current.next = new ListNode();
                current = current.next;
                current.val = over;
            }
        }

        return result;
    }

    @Test
    public void test() {

        ListNode l1 = ListNode.buildListNode(new int[] {2,4,3});
        ListNode l2 = ListNode.buildListNode(new int[] {5,6,4});
        Assert.assertTrue(addTwoNumbers(l1, l2).assertListNodeEquals(new int[]{7,0,8}));

        l1 = ListNode.buildListNode(new int[] {0});
        l2 = ListNode.buildListNode(new int[] {0});
        Assert.assertTrue(addTwoNumbers(l1, l2).assertListNodeEquals(new int[]{0}));

        l1 = ListNode.buildListNode(new int[] {9,9,9,9,9,9,9});
        l2 = ListNode.buildListNode(new int[] {9,9,9,9});
        Assert.assertTrue(addTwoNumbers(l1, l2).assertListNodeEquals(new int[]{8,9,9,9,0,0,0,1}));

        System.out.println("ok");
    }
}
