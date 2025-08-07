/*
 * @lc app=leetcode.cn id=116 lang=java
 * @lcpr version=30202
 *
 * [116] 填充每个节点的下一个右侧节点指针
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class PopulatingNextRightPointersInEachNode {

    // @lc code=start
    /*
     * // Definition for a Node.
     * class Node {
     * public int val;
     * public Node left;
     * public Node right;
     * public Node next;
     * 
     * public Node() {}
     * 
     * public Node(int _val) {
     * val = _val;
     * }
     * 
     * public Node(int _val, Node _left, Node _right, Node _next) {
     * val = _val;
     * left = _left;
     * right = _right;
     * next = _next;
     * }
     * };
     */

    

    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }

            traverse(root.left, root.right);
            return root;
        }

        private void traverse(Node left, Node right) {
            if (left == null || right == null) {
                return;
            }

            // *** 前序位置 ***
            // 将传入的两个节点穿起来
            left.next = right;

            // 连接相同父节点的两个子节点
            traverse(left.left, left.right);
            traverse(right.left, right.right);
            // 连接跨越父节点的两个子节点
            // dingyihui: 关键在于连接跨越父节点的两个子节点
            traverse(left.right, right.left);
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNode().new Solution();
        // put your test code here
        Node root = new Node(1, new Node(2, new Node(4), new Node(5), null),
                new Node(3, new Node(6), new Node(7), null),
                null);
        solution.connect(root);
        // print the next pointers
        printNextPointers(root);
    }

    private static void printNextPointers(Node root) {
        if (root == null) {
            return;
        }

        System.out.print("Node " + root.val + " next -> ");
        if (root.next != null) {
            System.out.println(root.next.val);
        } else {
            System.out.println("null");
        }

        printNextPointers(root.left);
        printNextPointers(root.right);
    }
}
/*
 * // @lcpr case=start
 * // [1,2,3,4,5,6,7]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n
 * // @lcpr case=end
 * 
 */
