/*
 * @lc app=leetcode.cn id=114 lang=java
 * @lcpr version=30202
 *
 * [114] 二叉树展开为链表
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class FlattenBinaryTreeToLinkedList {

    // @lc code=start
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }

            // 先递归拉平左右子树
            flatten(root.left);
            flatten(root.right);

            // ***后序遍历位置***
            // 1、左右子树已经被拉平成一条链表，保存下来
            TreeNode left = root.left;
            TreeNode right = root.right;
            
            // 2、将左子树作为右子树
            root.left = null;
            root.right = left;
            
            // 3、将原先的右子树接到当前右子树的末端
            TreeNode p = root;
            while (p.right != null) {
                p = p.right;
            }
            p.right = right;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
        // put your test code here
        TreeNode root = new TreeNode(1, 
            new TreeNode(2, new TreeNode(3), new TreeNode(4)), 
            new TreeNode(5, null, new TreeNode(6)));

        solution.flatten(root);
        printFlattenedTree(root);
    }

    private static void printFlattenedTree(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
        System.out.println();
    }
}



/*
// @lcpr case=start
// [1,2,5,3,4,null,6]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [0]\n
// @lcpr case=end

 */

