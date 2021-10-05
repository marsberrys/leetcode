package solutions.s429;

import base.Node;
import base.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * 429. N 叉树的层序遍历
 * @Author weixun
 * @Date 2021-10-04
 * @See https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class Solution {

    /**
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(null == root) {
            return res;
        }

        Queue<Node> nq = new LinkedList<>();
        nq.offer(root);

        while(!nq.isEmpty()) {
            int levelLen = nq.size();
            List<Integer> levelRes = new ArrayList<>();
            for (int i = 0; i < levelLen; i++) {
                Node cur = nq.poll();
                levelRes.add(cur.val);
                if(cur.children != null) {
                    for (Node childNode : cur.children) {
                        nq.offer(childNode);
                    }
                }
            }

            res.add(levelRes);
        }

        return res;
    }

    @Test
    public void test() {

        assert Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(3,2,4),
                Arrays.asList(5,6)
        ).equals(levelOrder(Node.buildMultiChildrenNodeRowByRowByNums(new Integer[]{1,null,3,2,4,null,5,6})));

        assert Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2,3,4,5),
                Arrays.asList(6,7,8,9,10),
                Arrays.asList(11,12,13),
                Arrays.asList(14)
        ).equals(levelOrder(Node.buildMultiChildrenNodeRowByRowByNums(new Integer[]{1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14})));

        System.out.println("ok");
    }
}
