package solutions.s116;
import base.Node;
import base.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * @Author weixun
 * @Date 2021-10-04
 * @See https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
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

        TreeNode node = TreeNode.buildPrefectBinaryTree(new Integer[]{1,2,3,4,5,6,7});
        // [1,#,2,3,#,4,5,6,7,#]
        node = connect(node);

        System.out.println("ok");
    }
}
