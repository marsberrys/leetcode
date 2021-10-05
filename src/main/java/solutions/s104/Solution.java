package solutions.s104;

import base.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 104. 二叉树的最大深度
 * @Author weixun
 * @Date 2021-10-05
 * @See https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class Solution {

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Queue<TreeNode> nq = new LinkedList<>();
        nq.offer(root);
        int maxLevel = 0;
        while(!nq.isEmpty()) {
            maxLevel++;
            int lSize = nq.size();
            for(int i = 0; i < lSize; i++) {
                TreeNode cur = nq.poll();
                if(cur.left != null) {
                    nq.offer(cur.left);
                }
                if(cur.right != null) {
                    nq.offer(cur.right);
                }
            }
        }

        return maxLevel;
    }

    @Test
    public void test() {

        Assert.assertEquals(3, maxDepth(TreeNode.buildBinaryTree(new Integer[]{3,9,20,null,null,15,7})));

        System.out.println("ok");
    }
}
