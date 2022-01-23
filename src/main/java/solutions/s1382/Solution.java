package solutions.s1382;

import base.ListNode;
import base.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 1382. 将二叉搜索树变平衡
 * @Author weixun
 * @Date 2021-11-02
 * @See https://leetcode-cn.com/problems/balance-a-binary-search-tree/
 */
public class Solution {

    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = inorder(root);
        if(null == list || list.isEmpty()) {
            return null;
        }

        TreeNode[] trees = list.toArray(new TreeNode[list.size()]);
        return buildBalanceTreeByArray(trees, 0 , list.size() - 1);
    }

    private List<TreeNode> inorder(TreeNode root) {
        if(root == null) {
            return null;
        }

        List<TreeNode> list = new ArrayList<>();
        if(null != root.left) {
            list.addAll(inorder(root.left));
        }
        list.add(root);
        if(null != root.left) {
            list.addAll(inorder(root.right));
        }

        return list;
    }

    private TreeNode buildBalanceTreeByArray(TreeNode[] trees, int from, int to) {
        if(from > to) {
            return null;
        }
        if(from == to) {
            return trees[from];
        }

        int mid = from + (to - from) / 2;
        TreeNode root = trees[mid];
        root.left = buildBalanceTreeByArray(trees, from, mid - 1);
        root.right = buildBalanceTreeByArray(trees, mid + 1, to);

        return root;
    }


    @Test
    public void test() {

        System.out.println("ok");
    }
}
