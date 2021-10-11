package solutions.s154_s2096;

import base.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 154. 寻找旋转排序数组中的最小值 II
 * 剑指 Offer 11. 旋转数组的最小数字
 * @Author weixun
 * @Date 2021-10-11
 * @See https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * @See https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
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
        ListNode slow = head, quick = head.next;
        while(null != slow && null != quick && null != quick.next) {
            if(slow == quick) {
                return true;
            }
            slow = slow.next;
            quick = quick.next.next;
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
