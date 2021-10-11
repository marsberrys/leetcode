package solutions.s101;

import base.TreeNode;
import org.junit.Test;


/**
 * 101. 对称二叉树
 * @Author weixun
 * @Date 2021-10-10
 * @See https://leetcode-cn.com/problems/symmetric-tree/
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null || left.val != right.val) {
            return false;
        }

        return check(left.left, right.right) && check(left.right, right.left);
    }

    @Test
    public void test() {

        System.out.println("ok");
    }
}
