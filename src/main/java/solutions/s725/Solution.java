package solutions.s725;

import base.ListNode;
import org.junit.Test;

/**
 * 725. 分隔链表
 * @Author weixun
 * @Date 2021-10-07
 * @See https://leetcode-cn.com/problems/split-linked-list-in-parts/
 */
public class Solution {

    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode cur = head;
        while(cur != null) {
            len++;
            cur = cur.next;
        }

        int groupSize = len / k;
        int mod = len % k;
        ListNode[] res = new ListNode[k];
        cur = head;
        int group = 0;
        while(cur != null) {
            res[group] = cur;
            int i = group < mod ? 0 : 1;
            for(; i < groupSize && cur != null; i++) {
                cur = cur.next;
            }

            if(cur != null) {
                ListNode next = cur.next;
                cur.next = null;
                cur = next;
                group++;
            }
        }

        return res;
    }

    @Test
    public void test() {

        System.out.println(splitListToParts(ListNode.buildListNode(new int[]{1,2,3}), 5));

        System.out.println(splitListToParts(ListNode.buildListNode(new int[]{1,2,3,4,5,6,7,8,9,10}), 3));

        System.out.println(splitListToParts(ListNode.buildListNode(new int[]{1,2,3,4,5,6,7,8,9,10}), 3));

        System.out.println(splitListToParts(ListNode.buildListNode(new int[]{}), 3));

        System.out.println("ok");
    }
}
