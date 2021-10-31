package solutions.s100;

import base.TreeNode;
import org.junit.Assert;
import org.junit.Test;


/**
 * 100. 相同的树
 * @Author weixun
 * @Date 2021-10-22
 * @See https://leetcode-cn.com/problems/same-tree/
 */
public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    @Test
    public void test() {

        Assert.assertEquals(true, isSameTree(TreeNode.buildBinaryTree(new Integer[]{1,2,3}), TreeNode.buildBinaryTree(new Integer[]{1,2,3})));

        Assert.assertEquals(false, isSameTree(TreeNode.buildBinaryTree(new Integer[]{1,2}), TreeNode.buildBinaryTree(new Integer[]{1,null,2})));

        Assert.assertEquals(false, isSameTree(TreeNode.buildBinaryTree(new Integer[]{1,2,1}), TreeNode.buildBinaryTree(new Integer[]{1,1,2})));

        System.out.println("ok");
    }
}
