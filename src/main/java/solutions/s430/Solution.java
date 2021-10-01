package solutions.s430;

import base.Node;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author weixun
 * @Date 2021-09-24
 * @See https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/
 */
public class Solution {

    public Node flatten(Node head) {
        Node.dfs(head);
        return head;
    }

    private int[] flattenNums(int[] nums) {
        Node node = Node.buildMultilevelNodeRowByRowByNums(nums);
        node = flatten(node);
        return Node.flattenNodeToNums(node).stream().mapToInt(Integer::valueOf).toArray();
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{1,2,3,7,8,11,12,9,10,4,5,6}, flattenNums(new int[]{1,2,3,4,5,6,-1,-1,-1,7,8,9,10,-1,-1,11,12}));

        Assert.assertArrayEquals(new int[]{1,3,2}, flattenNums(new int[]{1,2,-1,3}));

        Assert.assertArrayEquals(new int[]{}, flattenNums(new int[]{}));

        Assert.assertArrayEquals(new int[]{}, flattenNums(new int[]{}));

        System.out.println("ok");
    }
}
