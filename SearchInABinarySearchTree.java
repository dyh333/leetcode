/*
 * @lc app=leetcode.cn id=700 lang=java
 * @lcpr version=30203
 *
 * [700] 二叉搜索树中的搜索
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SearchInABinarySearchTree {

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
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) {
                return null;
            }

            if (root.val > val) {
                return searchBST(root.left, val);
            } else if (root.val < val) {
                return searchBST(root.right, val);
            }
            return root;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new SearchInABinarySearchTree().new Solution();
        // put your test code here
        TreeNode root = TreeNode.createRoot(new Integer[] { 4, 2, 7, 1, 3 });
        int val = 2;
        TreeNode result = solution.searchBST(root, val);
        // 输出TreeNode数组
        Integer[] array = TreeNode.toArray(result);
        System.out.println(Arrays.toString(array));
    }
}

/*
 * // @lcpr case=start
 * // [4,2,7,1,3]\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [4,2,7,1,3]\n5\n
 * // @lcpr case=end
 * 
 */
