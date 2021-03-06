package solutions.s141;

import base.ListNode;
import base.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 141. 环形链表
 * @Author weixun
 * @Date 2021-10-10
 * @See https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class Solution {

    /**
     * 哈希表实现
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> searched = new HashSet<>();

        ListNode cur = head;
        while(cur != null) {
            if(!searched.add(cur)) {
                return true;
            }
            cur = cur.next;
        }

        return false;
    }

    /**
     * 快慢指针实现
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head
     * @return
     */
    public boolean hasCycleQuickSlow(ListNode head) {
        if(null == head || null == head.next) {
            return false;
        }
        ListNode slow = head, quick = head;
        while(null != quick) {
            slow = slow.next;
            if(null == quick.next) {
                return false;
            } else {
                quick = quick.next.next;
            }

            if(slow == quick) {
                return true;
            }
        }

        return false;
    }


    @Test
    public void test() {

        Assert.assertEquals(true, hasCycle(ListNode.buildListNodeWithCircle(new int[]{3,2,0,-4}, 1)));

        Assert.assertEquals(true, hasCycle(ListNode.buildListNodeWithCircle(new int[]{1,2}, 0)));

        Assert.assertEquals(true, hasCycleQuickSlow(ListNode.buildListNodeWithCircle(new int[]{3,2,0,-4}, 1)));

        Assert.assertEquals(true, hasCycleQuickSlow(ListNode.buildListNodeWithCircle(new int[]{1,2}, 0)));

        System.out.println("ok");
    }
}
