package base;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author weixun
 * @Date 2021-09-28
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;


     TreeNode() {}

     TreeNode(int val) { this.val = val; }

     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }

     public int[] toPreOrderArray() {
         List<Integer> orderedList = preOrder(this);
         return orderedList == null ? null : orderedList.stream().mapToInt(Integer::valueOf).toArray();
     }

     private List<Integer> preOrder(TreeNode node) {
         List<Integer> orderedList = new ArrayList<>();
         if(node != null) {
            orderedList.add(node.val);
            orderedList.addAll(preOrder(node.left));
            orderedList.addAll(preOrder(node.right));
         }
         return orderedList;
     }

     public int[] toInOrderArray() {
         List<Integer> orderedList = inOrder(this);
         return orderedList == null ? null : orderedList.stream().mapToInt(Integer::valueOf).toArray();
     }

     private List<Integer> inOrder(TreeNode node) {
         List<Integer> orderedList = new ArrayList<>();
         if(node != null) {
            orderedList.addAll(inOrder(node.left));
            orderedList.add(node.val);
            orderedList.addAll(inOrder(node.right));
         }
         return orderedList;
     }

     public int[] toPostOrderArray() {
         List<Integer> orderedList = postOrder(this);
         return orderedList == null ? null : orderedList.stream().mapToInt(Integer::valueOf).toArray();
     }

     private List<Integer> postOrder(TreeNode node) {
         List<Integer> orderedList = new ArrayList<>();
         if(node != null) {
            orderedList.addAll(postOrder(node.left));
            orderedList.addAll(postOrder(node.right));
            orderedList.add(node.val);
         }
         return orderedList;
     }

     public static TreeNode buildTreeByArray(Integer[] nums) {
         if (null == nums || nums.length < 1) {
             return null;
         }

         Map<Integer, TreeNode> nodeMap = new HashMap<>();
         int len = nums.length;
         for (int i = 0; i <= len / 2; i++) {
            if(nums[i] == null) {
                continue;
            }

            if(null == nodeMap.get(i)) {
                nodeMap.put(i, new TreeNode(nums[i]));
            }

            // 右 child
            int rightChildIndex = (i + 1) * 2;
            if(rightChildIndex < len && null != nums[rightChildIndex]) {
                 if(null == nodeMap.get(rightChildIndex)) {
                     nodeMap.put(rightChildIndex, new TreeNode(nums[rightChildIndex]));
                 }
                 nodeMap.get(i).right = nodeMap.get(rightChildIndex);
            }

            // 左 child
            int leftChildIndex = rightChildIndex - 1;
            if(leftChildIndex < len && null != nums[leftChildIndex]) {
                 if(null == nodeMap.get(leftChildIndex)) {
                     nodeMap.put(leftChildIndex, new TreeNode(nums[leftChildIndex]));
                 }
                 nodeMap.get(i).left = nodeMap.get(leftChildIndex);
            }
         }

         return nodeMap.get(0);
     }

    public static void main(String[] args) {
        TreeNode node = TreeNode.buildTreeByArray(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1});
        System.out.println(Arrays.toString(node.toPreOrderArray()));
        System.out.println(Arrays.toString(node.toInOrderArray()));
        System.out.println(Arrays.toString(node.toPostOrderArray()));
    }
}
