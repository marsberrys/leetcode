package base;

/**
 * @Author weixun
 * @Date 2021-09-10
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }

    public Boolean assertListNodeEquals(ListNode target) {
        return assertTowListNode(this, target);
    }

    public Boolean assertListNodeEquals(int[] nums) {
        return assertTowListNode(this, buildListNodeWithNums(nums));
    }

    public static Boolean assertTowListNode(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return true;
        }

        if(l1 == null || l2 == null) {
            return false;
        }

        if(l1.val == l2.val) {
            boolean result = assertTowListNode(l1.next, l2.next);
            return result;
        }

        return false;
    }

    public static ListNode buildListNodeWithNums(int[] nums) {
        if(nums.length <= 0) {
            return null;
        }

        ListNode head = new ListNode();
        ListNode cursor = head;
        for (int i = 0; i < nums.length; i++) {
            cursor.val = nums[i];
            if(i < nums.length - 1) {
                cursor.next = new ListNode();
                cursor = cursor.next;
            }
        }

        return head;
    }
}
