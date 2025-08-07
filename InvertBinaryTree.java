/*
 * @lc app=leetcode.cn id=226 lang=java
 * @lcpr version=30202
 *
 * [226] 翻转二叉树
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class InvertBinaryTree {

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
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            // 翻转左右子树
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);

            // 交换左右子节点
            root.left = right;
            root.right = left;

            return root;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
        // put your test code here
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        TreeNode invertedRoot = solution.invertTree(root);
        System.out.println(invertedRoot); // Output: Inverted tree structure
    }
}

/*
 * // @lcpr case=start
 * // [4,2,7,1,3,6,9]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,1,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n
 * // @lcpr case=end
 * 
 */
