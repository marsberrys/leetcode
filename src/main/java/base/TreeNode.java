package base;

import java.util.*;

/**
 * @Author weixun
 * @Date 2021-09-28
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;


     TreeNode() {}

     TreeNode(int val) { this.val = val; }

     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }

     TreeNode(int val, TreeNode left, TreeNode right, TreeNode next) {
         this.val = val;
         this.left = left;
         this.right = right;
         this.next = next;
     }

     public int[] toPreOrderArray() {
         List<Integer> orderedList = preOrder(this);
         return orderedList == null ? null : orderedList.stream().mapToInt(Integer::valueOf).toArray();
     }

     public static List<Integer> preOrder(TreeNode node) {
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

     public static List<Integer> inOrder(TreeNode node) {
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

     public static List<Integer> postOrder(TreeNode node) {
         List<Integer> orderedList = new ArrayList<>();
         if(node != null) {
            orderedList.addAll(postOrder(node.left));
            orderedList.addAll(postOrder(node.right));
            orderedList.add(node.val);
         }
         return orderedList;
     }

     public Integer[] levelOrderArray() {
         List<Integer> list = levelOrder(this);
        return list == null ? null : list.toArray(new Integer[list.size()]);
     }

     public static List<Integer> levelOrder(TreeNode node) {
        Queue<TreeNode> nq = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        nq.offer(node);

        while(!nq.isEmpty()) {
            int levelSize = nq.size();
            List<Integer> levelRes = new ArrayList<>();
            int nullCount = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = nq.poll();
                if(curr == null) {
                    levelRes.add(null);
                    nullCount++;
                    continue;
                }

                levelRes.add(curr.val);
                nq.offer(curr.left);
                nq.offer(curr.right);
            }
            if(nullCount < levelSize) {
                res.addAll(levelRes);
            }
        }

        return res;
     }

     public boolean equals(Integer[] nums) {
         Integer[] selfNums = this.levelOrderArray();
         if(selfNums.length != nums.length) {
             return false;
         }

         for (int i = 0; i < selfNums.length; i++) {
             if(nums[i] != selfNums[i]) {
                 return false;
             }
         }

         return true;
     }

     public static TreeNode buildBinaryTree(Integer[] nums) {
        if(nums == null || nums.length < 1) {
             return null;
        }

        Queue<TreeNode> nq = new LinkedList<>();
        TreeNode head = new TreeNode(nums[0]);
        nq.offer(head);

        int i = 0;
        int len = nums.length;
        while(!nq.isEmpty() && i < len) {
            int levelSize = nq.size();
            for (int j = 0; j < levelSize; j++) {
                TreeNode curr = nq.poll();
                i++;
                if(i >= len) {
                    break;
                }
                if(nums[i] != null) {
                    curr.left = new TreeNode(nums[i]);
                    nq.offer(curr.left);
                }
                i++;
                if(i >= len) {
                    break;
                }
                if(i < len && nums[i] != null) {
                    curr.right = new TreeNode(nums[i]);
                    nq.offer(curr.right);
                }
            }
        }

        return head;
     }


     public static TreeNode buildPrefectBinaryTree(Integer[] nums) {
         TreeNode head = null;
         int len = nums.length;
         if(len <= 0) {
             return head;
         }

         TreeNode[] treeNodes = new TreeNode[len];
         for (int i = 0; i < len; i++) {
             treeNodes[i] = new TreeNode(nums[i]);
         }

         for (int i = 0; i < len; i++) {
             int leftChildIndex = 2 * i + 1;
             int rightChildIndex = 2 * (i + 1);
             treeNodes[i].left = leftChildIndex >= len ? null :  treeNodes[leftChildIndex];
             treeNodes[i].right = rightChildIndex >= len ? null :  treeNodes[rightChildIndex];
         }

         return treeNodes[0];
     }

    public static void main(String[] args) {
        TreeNode node = TreeNode.buildBinaryTree(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1});
        System.out.println(Arrays.toString(node.toPreOrderArray()));
        System.out.println(Arrays.toString(node.toInOrderArray()));
        System.out.println(Arrays.toString(node.toPostOrderArray()));
        System.out.println(Arrays.toString(node.levelOrderArray()));
        TreeNode node2 = TreeNode.buildBinaryTree(new Integer[]{1,2,3,null,null,4,5});
        System.out.println(Arrays.toString(node2.levelOrderArray()));
    }
}
