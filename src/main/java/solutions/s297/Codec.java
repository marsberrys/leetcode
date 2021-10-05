package solutions.s297;

import base.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * 297. 二叉树的序列化与反序列化
 * @Author weixun
 * @Date 2021-10-05
 * @See https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return TreeNode.levelOrder(root).stream().map(String::valueOf).collect(Collectors.joining(","));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(null == data || "".equals(data)) {
            return null;
        }

        String[] dataNums = data.split(",");
        Integer[] nums = new Integer[dataNums.length];
        for (int i = 0; i < dataNums.length; i++) {
            nums[i] = "null".equals(dataNums[i]) ? null : Integer.valueOf(dataNums[i]);
        }
        return TreeNode.buildBinaryTree(nums);
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode node = TreeNode.buildBinaryTree(new Integer[]{1,2,3,null,null,4,5});
        String serializeStr = codec.serialize(node);
        Assert.assertEquals("1,2,3,null,null,4,5", serializeStr);
        TreeNode node2 = codec.deserialize(serializeStr);
        assert node.equals(node2);

        System.out.println("ok");
    }
}
