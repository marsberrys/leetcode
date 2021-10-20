package solutions.s98;

import base.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 98. 验证二叉搜索树
 * @Author weixun
 * @Date 2021-10-18
 * @See https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class Solution {

    public boolean isValidBST(TreeNode root) {
        return isValidBSTMinMax(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTMinMax(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }
        if(root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBSTMinMax(root.left, min, root.val) && isValidBSTMinMax(root.right, root.val, max);
    }

    @Test
    public void test() {

        Assert.assertEquals(true, isValidBST(TreeNode.buildBinaryTree(new Integer[]{2,1,3})));

        Assert.assertEquals(false, isValidBST(TreeNode.buildBinaryTree(new Integer[]{5,1,4,null,null,3,6})));

        Assert.assertEquals(false, isValidBST(TreeNode.buildBinaryTree(new Integer[]{5,4,6,null,null,3,7})));

        Assert.assertEquals(true, isValidBST(TreeNode.buildBinaryTree(new Integer[]{2147483647})));

        System.out.println("ok");
    }
}
