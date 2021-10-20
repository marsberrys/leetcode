package solutions.s230;

import base.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. 二叉搜索树中第K小的元素
 * @Author weixun
 * @Date 2021-10-18
 * @See https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 */
public class Solution {

    private List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        return list.get(k - 1);
    }

    private void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    @Test
    public void test() {

        Assert.assertEquals(1, kthSmallest(TreeNode.buildBinaryTree(new Integer[]{3,1,4,null,2}), 1));

        Assert.assertEquals(3, kthSmallest(TreeNode.buildBinaryTree(new Integer[]{5,3,6,2,4,null,null,1}), 3));

        System.out.println("ok");
    }
}
