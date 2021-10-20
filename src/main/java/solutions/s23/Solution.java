package solutions.s23;

import base.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 23. 合并K个升序链表
 * @Author weixun
 * @Date 2021-10-21
 * @See https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }

        ListNode merged = new ListNode();
        ListNode cur = merged;

        boolean hasItem = true;
        while(hasItem) {
            hasItem = false;
            int mIdx = -1;
            for(int i = 0; i < lists.length; i++) {
                if(lists[i] != null) {
                    hasItem = true;

                    if(mIdx < 0 || lists[i].val < lists[mIdx].val) {
                        mIdx = i;
                    }
                }
            }

            if(mIdx >= 0) {
                cur.next = lists[mIdx];
                lists[mIdx] = lists[mIdx].next;
                cur = cur.next;
            }
        }

        return merged.next;
    }


    @Test
    public void test() {

        ListNode.buildListNode(new int[]{1,1,2,3,4,4,5,6}).assertListNodeEquals(mergeKLists(
                new ListNode[]{
                        ListNode.buildListNode(new int[]{1, 4, 5}),
                        ListNode.buildListNode(new int[]{1, 3, 4}),
                        ListNode.buildListNode(new int[]{2, 6})
                }
        ));

        Assert.assertEquals(null, mergeKLists(new ListNode[]{}));

        Assert.assertEquals(null, mergeKLists(new ListNode[]{null}));

        System.out.println("ok");
    }
}
