/*
 * @lc app=leetcode.cn id=98 lang=java
 * @lcpr version=30203
 *
 * [98] 验证二叉搜索树
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ValidateBinarySearchTree {

    // @lc code=start
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, null, null);
        }

        private boolean isValidBST(TreeNode node, TreeNode lower, TreeNode upper) {
            if (node == null)
                return true;
            if (lower != null && node.val <= lower.val)
                return false;
            if (upper != null && node.val >= upper.val)
                return false;
            return isValidBST(node.left, lower, node) && isValidBST(node.right, node, upper);
        }
    }
    // @lc code=end

    // Helper method to convert array to BST
    public static TreeNode arrayToBST(Integer[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        return buildTree(arr, 0);
    }

    private static TreeNode buildTree(Integer[] arr, int idx) {
        if (idx >= arr.length || arr[idx] == null)
            return null;
        TreeNode node = new TreeNode(arr[idx]);
        node.left = buildTree(arr, 2 * idx + 1);
        node.right = buildTree(arr, 2 * idx + 2);
        return node;
    }

    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
        // put your test code here
        Integer[] root = new Integer[] { 5, 1, 4, null, null, 3, 6 };
        TreeNode rootNode = arrayToBST(root);
        System.out.println(solution.isValidBST(rootNode));
    }
}

/*
 * // @lcpr case=start
 * // [2,1,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [5,1,4,null,null,3,6]\n
 * // @lcpr case=end
 * 
 */
