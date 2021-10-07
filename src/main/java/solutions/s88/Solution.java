package solutions.s88;

import org.junit.Assert;
import org.junit.Test;

/**
 * 88. 合并两个有序数组
 * @Author weixun
 * @Date 2021-10-07
 * @See https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur = m + n - 1;
        m--;
        n--;
        while(cur >= 0) {
            if(m < 0) {
                nums1[cur] = nums2[n];
                n--;
                cur--;
                continue;
            }
            if(n < 0) {
                nums1[cur] = nums1[m];
                m--;
                cur--;
                continue;
            }
            if(nums1[m] >= nums2[n]) {
                nums1[cur] = nums1[m];
                m--;
            } else {
                nums1[cur] = nums2[n];
                n--;
            }
            cur--;
        }
    }


    @Test
    public void test() {

        int[] a = new int[]{1,2,3,0,0,0};
        merge(a, 3, new int[]{2,5,6}, 3);
        Assert.assertArrayEquals(new int[]{1,2,2,3,5,6}, a);

        int[] b = new int[]{1};
        merge(b, 1, new int[]{}, 0);
        Assert.assertArrayEquals(new int[]{1}, b);

        int[] c = new int[]{0};
        merge(c, 0, new int[]{1}, 1);
        Assert.assertArrayEquals(new int[]{1}, c);

        System.out.println("ok");
    }
}
