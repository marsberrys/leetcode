package solutions.s349;

import base.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 349. 两个数组的交集
 * @Author weixun
 * @Date 2021-10-12
 * @See https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> res = new HashSet<>();
        int p1 = 0, p2 = 0;
        while(p1 < nums1.length && p2 < nums2.length) {
            if(nums1[p1] < nums2[p2]) {
                p1++;
            } else if(nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                res.add(nums1[p1]);
                p1++;
                p2++;
            }
        }


        return res.stream().mapToInt(Integer::valueOf).toArray();
    }


    @Test
    public void test() {

        Assert.assertArrayEquals(new int[]{2}, intersection(new int[]{1,2,2,1}, new int[]{2,2}));

        Assert.assertArrayEquals(new int[]{4,9}, intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4}));

        System.out.println("ok");
    }
}
