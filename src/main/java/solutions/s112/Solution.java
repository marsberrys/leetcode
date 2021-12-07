package solutions.s112;

import base.ListNode;
import base.TreeNode;
import org.junit.Assert;
import org.junit.Test;


/**
 * 112. 路径总和
 * @Author weixun
 * @Date 2021-10-10
 * @See https://leetcode-cn.com/problems/path-sum/
 */
public class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }

        if(root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    @Test
    public void test() {

        Assert.assertEquals(true, hasPathSum(TreeNode.buildBinaryTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1}), 22));

        Assert.assertEquals(false, hasPathSum(TreeNode.buildBinaryTree(new Integer[]{1,2,3}), 5));

        Assert.assertEquals(false, hasPathSum(TreeNode.buildBinaryTree(new Integer[]{1,2}), 0));

        System.out.println("ok");
    }
}
