package solutions.s786;

import base.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 786. 第 K 个最小的素数分数
 * @Author weixun
 * @Date 2021-11-29
 * @See https://leetcode-cn.com/problems/k-th-smallest-prime-fraction/
 */
public class Solution {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double left = 0d, right = 1d;
        int n = arr.length;

        while(true) {
            int count = 0;
            double mid = left + (right - left) / 2d;
            int x = 0, y = 1;
            for(int j = 1; j < n; j++) {
                for(int i = 0; i < j; i++) {
                    if((double) arr[i] / arr[j] < mid) {
                        if(arr[i] * y > arr[j] * x) {
                            x = arr[i];
                            y = arr[j];
                        }
                        count++;
                    }
                }
            }

            if(count == k) {
                return new int[]{x, y};
            } else if(count < k) {
                left = mid;
            } else {
                right = mid;
            }
        }
    }

    @Test
    public void test() {

        Assert.assertArrayEquals(new int[]{13,17}, kthSmallestPrimeFraction(new int[]{1,13,17,59}, 6));

        Assert.assertArrayEquals(new int[]{2,5}, kthSmallestPrimeFraction(new int[]{1,2,3,5}, 3));

        Assert.assertArrayEquals(new int[]{1,7}, kthSmallestPrimeFraction(new int[]{1,7}, 1));

        System.out.println("ok");
    }
}
