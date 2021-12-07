package solutions.s113;

import base.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 113. 路径总和 II
 * @Author weixun
 * @Date 2021-11-29
 * @See https://leetcode-cn.com/problems/path-sum-ii/
 */
public class Solution {

    private List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        search(root, targetSum, path);
        return ans;
    }

    private void search(TreeNode root, int targetSum, List<Integer> path) {
        path.add(root.val);

        if(root.left == null && root.right == null) {
            if(targetSum == root.val) {
                ans.add(new ArrayList<Integer>(path));
            }
            path.remove(path.size() - 1);
            return;
        }

        if(null != root.left) {
            search(root.left, targetSum - root.val, path);
        }
        if(null != root.right) {
            search(root.right, targetSum - root.val, path);
        }
        path.remove(path.size() - 1);
    }

    @Test
    public void test() {

        assert Arrays.asList(
                Arrays.asList(5,4,11,2),
                Arrays.asList(5,8,4,5)
        ).equals(pathSum(TreeNode.buildBinaryTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1}), 22));

        assert Arrays.asList(
                Arrays.asList()
        ).equals(pathSum(TreeNode.buildBinaryTree(new Integer[]{1,2,3}), 5));

        assert Arrays.asList(
                Arrays.asList()
        ).equals(pathSum(TreeNode.buildBinaryTree(new Integer[]{1,2}), 0));

        System.out.println("ok");
    }
}
