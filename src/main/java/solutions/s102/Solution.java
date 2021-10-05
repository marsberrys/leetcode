package solutions.s102;

import base.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 * @Author weixun
 * @Date 2021-10-04
 * @See https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> nq = new LinkedList<>();
        nq.offer(root);
        while(!nq.isEmpty()) {
            int lSize = nq.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < lSize; i++){
                TreeNode cur = nq.poll();
                level.add(cur.val);
                if(cur.left != null) {
                    nq.offer(cur.left);
                }
                if(cur.right != null) {
                    nq.offer(cur.right);
                }
            }
            res.add(level);
        }

        return res;
    }

    @Test
    public void test() {

        assert Arrays.asList(
                Arrays.asList(3),
                Arrays.asList(9,20),
                Arrays.asList(15,7)
        ).equals(levelOrder(TreeNode.buildBinaryTree(new Integer[]{3,9,20,null,null,15,7})));

        System.out.println("ok");
    }
}
