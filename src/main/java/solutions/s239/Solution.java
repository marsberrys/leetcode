package solutions.s239;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;


/**
 * 239. 滑动窗口最大值
 * @Author weixun
 * @Date 2021-10-30
 * @See https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        LinkedList<Integer> q = new LinkedList<>();

        for(int i = 0; i < len; i++) {
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }


            q.offer(i);
            if(q.peek() <= i - k) {
                q.poll();
            }

            if(i + 1 >= k) {
                res[i + 1 - k] = nums[q.peek()];
            }
        }

        return res;
    }

    @Test
    public void test() {

        Assert.assertArrayEquals(new int[]{7,7,7,7,7}, maxSlidingWindow(new int[]{7,-8,7,5,7,1,6,0}, 4));

        Assert.assertArrayEquals(new int[]{7,4}, maxSlidingWindow(new int[]{7,2,4}, 2));

        Assert.assertArrayEquals(new int[]{3,3,5,5,6,7}, maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));

        Assert.assertArrayEquals(new int[]{1}, maxSlidingWindow(new int[]{1}, 1));

        Assert.assertArrayEquals(new int[]{1,-1}, maxSlidingWindow(new int[]{1,-1}, 1));

        Assert.assertArrayEquals(new int[]{11}, maxSlidingWindow(new int[]{9,11}, 2));

        System.out.println("ok");
    }
}
