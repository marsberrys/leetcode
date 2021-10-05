package solutions.s111;

import base.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 * @Author weixun
 * @Date 2021-10-05
 * @See https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class Solution {

    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Queue<TreeNode> nq = new LinkedList<>();
        nq.offer(root);
        int minLevel = 0;
        while(!nq.isEmpty()) {
            minLevel++;
            int lSize = nq.size();
            for(int i = 0; i < lSize; i++) {
                TreeNode cur = nq.poll();
                if(cur.left == null && cur.right == null) {
                    // 第一个遇到的叶子节点一定是最小层高
                    return minLevel;
                }
                if(cur.left != null) {
                    nq.offer(cur.left);
                }
                if(cur.right != null) {
                    nq.offer(cur.right);
                }
            }
        }

        return minLevel;
    }

    public int minDepthDFS(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }

        int minLevel = Integer.MAX_VALUE;
        if(root.left != null) {
            minLevel = Math.min(minDepthDFS(root.left), minLevel);
        }
        if(root.right != null) {
            minLevel = Math.min(minDepthDFS(root.right), minLevel);
        }

        return minLevel + 1;
    }

    @Test
    public void test() {

        Assert.assertEquals(2, minDepth(TreeNode.buildBinaryTree(new Integer[]{3,9,20,null,null,15,7})));

        Assert.assertEquals(5, minDepth(TreeNode.buildBinaryTree(new Integer[]{2,null,3,null,4,null,5,null,6})));

        Assert.assertEquals(2, minDepthDFS(TreeNode.buildBinaryTree(new Integer[]{3,9,20,null,null,15,7})));

        Assert.assertEquals(5, minDepthDFS(TreeNode.buildBinaryTree(new Integer[]{2,null,3,null,4,null,5,null,6})));

        System.out.println("ok");
    }
}
