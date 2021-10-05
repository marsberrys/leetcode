package solutions.s515;
import base.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * 515. 在每个树行中找最大值
 * @Author weixun
 * @Date 2021-10-04
 * @See https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 */
public class Solution {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(null == root) {
            return res;
        }

        Queue<TreeNode> nq = new LinkedList<>();
        nq.offer(root);

        while(!nq.isEmpty()) {
            int levelLen = nq.size();
            int levelMax = Integer.MIN_VALUE;

            for (int i = 0; i < levelLen; i++) {
                TreeNode cur = nq.poll();
                if(cur.val > levelMax) {
                    levelMax = cur.val;
                }
                if(cur.left != null) {
                    nq.offer(cur.left);
                }
                if(cur.right != null) {
                    nq.offer(cur.right);
                }
            }

            res.add(levelMax);
        }

        return res;
    }

    @Test
    public void test() {

        assert Arrays.asList(1,3,9).equals(largestValues(TreeNode.buildBinaryTree(new Integer[]{1,3,2,5,3,null,9})));

        assert Arrays.asList(1,3).equals(largestValues(TreeNode.buildBinaryTree(new Integer[]{1,2,3})));

        assert Arrays.asList(1).equals(largestValues(TreeNode.buildBinaryTree(new Integer[]{1})));

        assert Arrays.asList(1,2).equals(largestValues(TreeNode.buildBinaryTree(new Integer[]{1,null,2})));

        System.out.println("ok");
    }
}
