package solutions.s117;

import base.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * @Author weixun
 * @Date 2021-10-05
 * @See https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class Solution {

    public TreeNode connect(TreeNode root) {
        Queue<TreeNode> nq = new LinkedList<>();
        if(root == null) {
            return root;
        }
        nq.offer(root);
        while(!nq.isEmpty()) {
            int levelSize = nq.size();
            TreeNode prev = null;
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = nq.poll();
                if(prev != null) {
                    prev.next = cur;
                }
                prev = cur;
                if(null != cur.left) {
                    nq.offer(cur.left);
                }
                if(null != cur.right) {
                    nq.offer(cur.right);
                }
            }
        }

        return root;
    }

    @Test
    public void test() {

        TreeNode node = TreeNode.buildPrefectBinaryTree(new Integer[]{1,2,3,4,5,null,7});
        // 输出：[1,#,2,3,#,4,5,7,#]
        node = connect(node);

        System.out.println("ok");
    }
}
