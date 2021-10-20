package solutions.s108;

import base.TreeNode;
import org.junit.Assert;
import org.junit.Test;


/**
 * 108. 将有序数组转换为二叉搜索树
 * @Author weixun
 * @Date 2021-10-18
 * @See https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if(left == right) {
            return new TreeNode(nums[left]);
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if(mid > left) {
            root.left = buildBST(nums, left, mid - 1);
        }
        if(mid < right) {
            root.right = buildBST(nums, mid + 1, right);
        }

        return root;
    }

    @Test
    public void test() {

        // [0,-3,9,-10,null,5] or [0,-10,5,null,-3,null,9]
        System.out.println(TreeNode.levelOrder(sortedArrayToBST(new int[]{-10, -3, 0, 5, 9})));

        // [1,3] 和 [3,1]
        System.out.println(TreeNode.levelOrder(sortedArrayToBST(new int[]{1,3})));

        System.out.println("ok");
    }
}
