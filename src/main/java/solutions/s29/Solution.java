package solutions.s29;

import base.ListNode;
import org.junit.Test;


/**
 * @Author weixun
 * @Date 2021-09-10
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ListNode l1 = new ListNode();
        System.out.println(nums1);
        System.out.println(nums2);
        return 0d;
    }

    @Test
    public void test() {
        Solution solution = new Solution();

        int[] nums1 = new int[]{1,2,3};
        int[] nums2 = new int[]{3,5,6};
        solution.findMedianSortedArrays(nums1, nums2);
    }
}
