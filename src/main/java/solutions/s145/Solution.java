package solutions.s145;

import base.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 145. 二叉树的后序遍历
 * @Author weixun
 * @Date 2021-10-22
 * @See https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        res.addAll(postorderTraversal(root.left));
        res.addAll(postorderTraversal(root.right));
        res.add(root.val);
        return res;
    }


    @Test
    public void test() {

        Arrays.asList(3,2,1).equals(postorderTraversal(TreeNode.buildBinaryTree(new Integer[]{1,null,2,3})));

        System.out.println("ok");
    }
}
