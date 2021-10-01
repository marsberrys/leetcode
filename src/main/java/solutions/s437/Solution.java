package solutions.s437;

import base.Node;
import base.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author weixun
 * @Date 2021-09-28
 * @See https://leetcode-cn.com/problems/path-sum-iii/
 */
public class Solution {

    public int pathSum(TreeNode root, int targetSum) {
        if(null == root) {
            return 0;
        }
        int result = getNodePaths(root, targetSum);
        result += pathSum(root.left, targetSum);
        result += pathSum(root.right, targetSum);
        return result;
    }

    public int getNodePaths(TreeNode node, int targetSum) {
        if(node == null) {
            return 0;
        }

        int result = 0;
        if(node.val == targetSum) {
            result++;
        }

        result += getNodePaths(node.left, targetSum - node.val);
        result += getNodePaths(node.right, targetSum - node.val);
        return result;
    }

    @Test
    public void test() {

        Assert.assertEquals(3, pathSum(TreeNode.buildTreeByArray(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1}), 8));

        Assert.assertEquals(3, pathSum(TreeNode.buildTreeByArray(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1}), 22));

        Assert.assertEquals(4, pathSum(TreeNode.buildTreeByArray(new Integer[]{1,-2,-3,1,3,-2,null,-1}), -1));

        System.out.println("ok");
    }
}
