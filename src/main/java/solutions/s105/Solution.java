package solutions.s105;

import base.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * @Author weixun
 * @Date 2022-01-05
 * @See https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class Solution {

    private static HashMap<Integer, Integer> mp;

    /**
     * 从前序与中序遍历序列构造二叉树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        mp = new HashMap<>();
        for(int i = 0; i< len; i++) {
            mp.put(inorder[i], i);
        }

        return dfs(preorder, inorder, 0, len - 1, 0, len - 1);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if(pl > pr) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pl]);
        int inMid = mp.get(preorder[pl]);
        int leftChildLen = inMid - il;
        root.left = dfs(preorder, inorder, pl + 1, pl + leftChildLen, il, inMid - 1);
        root.right = dfs(preorder, inorder, pl + leftChildLen + 1, pr,inMid + 1, ir);
        return root;
    }

    private static int cnt;
    /**
     * 从前序与中序遍历序列求后序遍历
     * @param preorder
     * @param inorder
     * @return
     */
    public int[] postSearch(int[] preorder, int[] inorder) {
        int len = preorder.length;
        mp = new HashMap<>();
        for(int i = 0; i< len; i++) {
            mp.put(inorder[i], i);
        }

        int[] result = new int[len];
        cnt = 0;
        dfs(preorder, inorder, 0, len - 1, 0, len - 1, result);
        return result;
    }

    private void dfs(int[] preorder, int[] inorder, int pl, int pr, int il, int ir, int[] result) {
        if(pl > pr) {
            return;
        }

        int root = preorder[pl];
        int inMid = mp.get(preorder[pl]);
        int leftChildLen = inMid - il;
        if(inMid > il) {
            dfs(preorder, inorder, pl + 1, pl + leftChildLen, il, inMid - 1, result);
        }
        if(inMid < ir) {
            dfs(preorder, inorder, pl + leftChildLen + 1, pr,inMid + 1, ir, result);
        }
        result[cnt] = root;
        cnt++;
    }

    @Test
    public void test() {
        assert buildTree(
                new int[]{3,9,20,15,7},
                new int[]{9,3,15,20,7}
        ).equals(new Integer[]{3,9,20,null,null,15,7});

        Assert.assertArrayEquals(new int[]{8,7,5,3,2}, postSearch(new int[]{2,5,8,7,3}, new int[]{8,5,7,2,3}));

        System.out.println("ok");
    }
}
