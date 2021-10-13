package solutions.s142_s2298;

import base.ListNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 142. 环形链表 II
 * 面试题 02.08. 环路检测
 * @Author weixun
 * @Date 2021-10-12
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * @See https://leetcode-cn.com/problems/linked-list-cycle-lcci/
 */
public class Solution {

    /**
     * 哈希表实现
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * @param head
     * @return
     */
    public ListNode hasCycle(ListNode head) {
        Set<ListNode> searched = new HashSet<>();

        ListNode cur = head;
        while(cur != null) {
            if(!searched.add(cur)) {
                return cur;
            }
            cur = cur.next;
        }

        return null;
    }

    /**
     * 快慢指针实现
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head
     * @return
     */
    public ListNode hasCycleQuickSlow(ListNode head) {
        if(null == head || null == head.next) {
            return null;
        }
        ListNode slow = head, quick = head;
        while(null != quick) {
            slow = slow.next;
            if(null == quick.next) {
                return null;
            } else {
                quick = quick.next.next;
            }

            if(slow == quick) {
                ListNode p = head;
                while(p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }

        return null;
    }


    @Test
    public void test() {

        System.out.println("ok");
    }
}
