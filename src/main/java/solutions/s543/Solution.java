package solutions.s543;

import base.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 543. 二叉树的直径
 * @Author weixun
 * @Date 2021-10-10
 * @See https://leetcode-cn.com/problems/diameter-of-binary-tree/
 */
public class Solution {

    private int maxPoints = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return maxPoints;
        }

        maxPoints = 1;
        depth(root);

        return maxPoints - 1;
    }

    private int depth(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int left = depth(node.left);
        int right = depth(node.right);
        maxPoints = Math.max(maxPoints, (left + right + 1));

        return Math.max(left, right) + 1;
    }

    @Test
    public void test() {

        Assert.assertEquals(3, diameterOfBinaryTree(TreeNode.buildBinaryTree(new Integer[]{1,null,2,3,null,4,5})));

        System.out.println("ok");
    }
}
