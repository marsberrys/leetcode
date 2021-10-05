package solutions.s199;

import base.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * 199.二叉树的右视图
 * @Author weixun
 * @Date 2021-10-04
 * @See https://leetcode-cn.com/problems/binary-tree-right-side-view/
 */
public class Solution {

    /**
     * BFS 实现
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> nq = new LinkedList<>();
        nq.offer(root);

        while(!nq.isEmpty()) {
            int levelLen = nq.size();
            for (int i = 0; i < levelLen; i++) {
                TreeNode curr = nq.poll();
                if(curr == null) {
                    continue;
                }

                if(i == 0) {
                    res.add(curr.val);
                }
                if(curr.right != null) {
                    nq.offer(curr.right);
                }
                if(curr.left != null) {
                    nq.offer(curr.left);
                }
            }
        }

        return res;
    }

    /**
     * DFS 实现
     * @param root
     * @return
     */
    private static List<Integer> dfsRes = new ArrayList<>();
    public List<Integer> rightSideViewDFS(TreeNode root) {
        dfsRes.clear();

        dfs(root, 0);

        return dfsRes;
    }

    private void dfs(TreeNode node, int depth) {
        if(node == null) {
            return;
        }

        if(dfsRes.size() == depth) {
            dfsRes.add(node.val);
        }

        depth++;
        dfs(node.right, depth);
        dfs(node.left, depth);
    }

    @Test
    public void test() {

        assert Arrays.asList(1,3,4).equals(rightSideView(TreeNode.buildBinaryTree(new Integer[]{1,2,3,null,5,null,4})));

        assert Arrays.asList(1,3).equals(rightSideView(TreeNode.buildBinaryTree(new Integer[]{1,null,3})));

        assert Arrays.asList().equals(rightSideView(TreeNode.buildBinaryTree(new Integer[]{})));

        assert Arrays.asList(1,3,4).equals(rightSideViewDFS(TreeNode.buildBinaryTree(new Integer[]{1,2,3,null,5,null,4})));

        assert Arrays.asList(1,3).equals(rightSideViewDFS(TreeNode.buildBinaryTree(new Integer[]{1,null,3})));

        assert Arrays.asList().equals(rightSideViewDFS(TreeNode.buildBinaryTree(new Integer[]{})));

        System.out.println("ok");
    }
}
