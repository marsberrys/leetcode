package solutions.s4;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author weixun
 * @Date 2021-09-14
 * @See https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mid = (nums1.length + nums2.length) / 2;
        int i1 = -1, i2 = -1;
        double p1 = 0, p2 = 0;
        while(i1 + i2 + 1 < mid) {
            p1 = p2;
            if(i1 + 1 >= nums1.length) {
                p2 = nums2[i2 + 1];
                i2++;
                continue;
            }
            if(i2 + 1 >= nums2.length) {
                p2 = nums1[i1 + 1];
                i1++;
                continue;
            }
            if(nums1[i1 + 1] <= nums2[i2 + 1]) {
                p2 = nums1[i1 + 1];
                i1++;
            } else {
                p2 = nums2[i2 + 1];
                i2++;
            }
        }

        if((nums1.length + nums2.length) % 2 != 0) {
            return p2;
        } else {
            return (p1 + p2) / 2;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();

        Assert.assertEquals(2.0000d, solution.findMedianSortedArrays(new int[] {1,3}, new int[] {2}),  0.0001d);

        Assert.assertEquals(2.5000d, solution.findMedianSortedArrays(new int[] {1,2}, new int[] {3,4}),  0.0001d);

        Assert.assertEquals(0d, solution.findMedianSortedArrays(new int[] {0,0}, new int[] {0,0}),  0.0001d);

        Assert.assertEquals(1d, solution.findMedianSortedArrays(new int[] {}, new int[] {1}),  0.0001d);

        Assert.assertEquals(2d, solution.findMedianSortedArrays(new int[] {2}, new int[] {}),  0.0001d);

        System.out.println("ok");
    }
}
