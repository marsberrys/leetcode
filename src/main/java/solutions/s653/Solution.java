package solutions.s653;

import base.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 653. 两数之和 IV - 输入 BST
 * @Author weixun
 * @Date 2021-10-05
 * @See https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 */
public class Solution {

    public boolean findTarget(TreeNode root, int k) {
        if(root == null) {
            return false;
        }

        Set<Integer> nodeSet = new HashSet<>();
        Queue<TreeNode> nq = new LinkedList<>();
        nq.offer(root);

        while(!nq.isEmpty()) {
            int levelSize = nq.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = nq.poll();
                int need = k - curr.val;
                if(nodeSet.contains(need)) {
                    return true;
                }

                nodeSet.add(curr.val);
                if(curr.left != null) {
                    nq.offer(curr.left);
                }
                if(curr.right != null) {
                    nq.offer(curr.right);
                }
            }
        }

        return false;
    }


    @Test
    public void test() {

        Assert.assertEquals(true, findTarget(TreeNode.buildBinaryTree(new Integer[]{5,3,6,2,4,null,7}), 9));

        Assert.assertEquals(false, findTarget(TreeNode.buildBinaryTree(new Integer[]{5,3,6,2,4,null,7}), 28));

        Assert.assertEquals(true, findTarget(TreeNode.buildBinaryTree(new Integer[]{2,1,3}), 4));

        Assert.assertEquals(false, findTarget(TreeNode.buildBinaryTree(new Integer[]{2,1,3}), 1));

        Assert.assertEquals(true, findTarget(TreeNode.buildBinaryTree(new Integer[]{2,1,3}), 3));

        System.out.println("ok");
    }
}
