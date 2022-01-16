package solutions.s2189;

import base.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 剑指 Offer 26. 树的子结构
 * @Author weixun
 * @Date 2021-12-24
 * @See https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 */
public class Solution {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) {
            return false;
        }
        return check(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean check(TreeNode A, TreeNode B) {
        if(B == null) {
            return true;
        }
        if(A == null || A.val != B.val) {
            return false;
        }

        return check(A.left, B.left) && check(A.right, B.right);
    }

    @Test
    public void test() {

        Assert.assertEquals(true, isSubStructure(TreeNode.buildBinaryTree(new Integer[]{3,4,5,1,2}), TreeNode.buildBinaryTree(new Integer[]{4,1})));

        Assert.assertEquals(false, isSubStructure(TreeNode.buildBinaryTree(new Integer[]{1,0,1,-4,-3}), TreeNode.buildBinaryTree(new Integer[]{1,-4})));

        System.out.println("ok");
    }
}
