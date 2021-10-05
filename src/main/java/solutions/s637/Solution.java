package solutions.s637;

import base.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * 637. 二叉树的层平均值
 * @Author weixun
 * @Date 2021-10-04
 * @See https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 */
public class Solution {

    /**
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(null == root) {
            return res;
        }

        Queue<TreeNode> nq = new LinkedList<>();
        nq.offer(root);

        while(!nq.isEmpty()) {
            int levelLen = nq.size();
            double levelSum = 0;
            for (int i = 0; i < levelLen; i++) {
                TreeNode curr = nq.poll();
                levelSum += curr.val;

                if(curr.right != null) {
                    nq.offer(curr.right);
                }
                if(curr.left != null) {
                    nq.offer(curr.left);
                }
            }

            res.add(levelSum / levelLen);
        }

        return res;
    }

    @Test
    public void test() {

        assert Arrays.asList(3D, 14.5D, 11D).equals(averageOfLevels(TreeNode.buildBinaryTree(new Integer[]{3,9,20,null,null,15,7})));

        System.out.println("ok");
    }
}
