package solutions.s94;

import base.ListNode;
import base.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 94. 二叉树的中序遍历
 * @Author weixun
 * @Date 2021-10-18
 * @See https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));

        return res;
    }

    @Test
    public void test() {

        assert Arrays.asList(1,3,2).equals(inorderTraversal(TreeNode.buildBinaryTree(new Integer[]{1,null,2,3})));

        assert Arrays.asList().equals(inorderTraversal(TreeNode.buildBinaryTree(new Integer[]{})));

        assert Arrays.asList(1).equals(inorderTraversal(TreeNode.buildBinaryTree(new Integer[]{1})));

        System.out.println("ok");
    }
}
