package solutions.s144;

import base.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 144. 二叉树的前序遍历
 * @Author weixun
 * @Date 2021-10-22
 * @See https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }


    @Test
    public void test() {

        Arrays.asList(1,2,3).equals(preorderTraversal(TreeNode.buildBinaryTree(new Integer[]{1,null,2,3})));

        System.out.println("ok");
    }
}
