package solutions.s103;

import base.ListNode;
import base.TreeNode;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 103. 二叉树的锯齿形层序遍历
 * @Author weixun
 * @Date 2021-10-14
 * @See https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> nq = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(null == root) {
            return res;
        }
        nq.offer(root);
        boolean left2right = true;
        while(!nq.isEmpty()) {
            int levelSize = nq.size();
            List<Integer> levelRes = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = nq.poll();
                levelRes.add(cur.val);
                if(cur.left != null) {
                    nq.offer(cur.left);
                }
                if(cur.right != null) {
                    nq.offer(cur.right);
                }
            }
            if(!left2right) {
                Collections.reverse(levelRes);
            }
            res.add(levelRes);
            left2right = !left2right;
        }

        return res;
    }

    @Test
    public void test() {

        assert Arrays.asList(
                Arrays.asList(3),
                Arrays.asList(20,9),
                Arrays.asList(7,15)
        ).equals(zigzagLevelOrder(TreeNode.buildBinaryTree(new Integer[]{3,9,20,null,null,15,7})));

        System.out.println("ok");
    }
}
