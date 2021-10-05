package base;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @Author weixun
 * @Date 2021-09-24
 */
public class Node {

    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public List<Node> children;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node prev) {
        this.val = val;
        this.prev = prev;
    }

    public Node(int val, Node prev, Node next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }

    public Node(int val, Node prev, Node next, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }

    public static Node dfs(Node head) {
        Node cursor = head;
        Node tailNode = null;

        while(cursor != null) {
            if(cursor.child != null) {
                Node childTailNode = dfs(cursor.child);
                if(cursor.next != null) {
                    // move cursor next to child tail
                    childTailNode.next = cursor.next;
                    cursor.next.prev = childTailNode;
                }

                cursor.next = cursor.child;
                cursor.child.prev = cursor;
                cursor.child = null;

                tailNode = childTailNode;
            } else {
                tailNode = cursor;
            }

            cursor = tailNode.next;
        }

        return tailNode;
    }

    /**
     * 用特定结算数组创建多级链表
     * @param nums
     * @return
     */
    public static Node buildMultilevelNodeRowByRowByNums(int[] nums) {
        if(nums.length <= 0) {
            return null;
        }

        Node head = new Node(nums[0]);
        Node cursor = head;
        for (int i = 1; i < nums.length; i++) {
            if(null == cursor) {
                return head;
            }

            if(nums[i] > 0) {
                Node nextNode = new Node(nums[i]);
                if(nums[i - 1] > 0) {
                    // add node to next
                    nextNode.prev = cursor;
                    cursor.next = nextNode;
                } else {
                    // add node to child
                    cursor.child = nextNode;
                }
                cursor = nextNode;
            } else {
                if(null != cursor.next) {
                    // move cursor to next
                    cursor = cursor.next;
                } else {
                    // back to row head
                    while(null != cursor.prev) {
                        cursor = cursor.prev;
                    }
                }
            }
        }

        return head;
    }

    /**
     * N 叉树构建
     * @param nums
     * @return
     */
    public static Node buildMultiChildrenNodeRowByRowByNums(Integer[] nums) {
        int len = nums.length;
        if(len <= 0) {
            return null;
        }

        Queue<Node> nq = new LinkedList<>();
        Node head = new Node(nums[0]);
        nq.offer(head);
        if(len < 3) {
            return head;
        }

        for (int i = 2; i < len; i++) {
            List<Node> children = new ArrayList<>();
            while(i < len && nums[i] != null)  {
                Node cur = new Node(nums[i]);
                nq.offer(cur);
                children.add(cur);
                i++;
            }

            Node parent = nq.poll();
            if(children.size() > 0) {
               parent.children = children;
            }
        }

        return head;
    }

    /**
     * 单级双链表转数组
     * @param node
     * @return
     */
    public static List<Integer> flattenNodeToNums(Node node) {
        List<Integer> numList = new ArrayList<>();
        Node cursor = node;
        while(cursor != null) {
            numList.add(cursor.val);
            cursor = cursor.next;
        }

        return numList;
    }

    public static void main(String[] args) {
        // Node head = buildMultilevelNodeRowByRowByNums(new int[]{1,2,3,4,5,6,-1,-1,-1,7,8,9,10,-1,-1,11,12});
        // dfs(head);
        // List<Integer> numList = flattenNodeToNums(head);
        // System.out.println(numList == null ? "null" : numList.stream().map(String::valueOf).collect(Collectors.joining(",")));

        Node multiChildrenNode = buildMultiChildrenNodeRowByRowByNums(new Integer[]{1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14});

        System.out.println("ok");
    }
}
