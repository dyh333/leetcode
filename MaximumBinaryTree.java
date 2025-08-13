/*
 * @lc app=leetcode.cn id=654 lang=java
 * @lcpr version=30202
 *
 * [654] 最大二叉树
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MaximumBinaryTree {

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
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (nums.length == 0) {
                return null;
            }

            int max = -1, maxIndex = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    maxIndex = i;
                }
            }

            TreeNode root = new TreeNode(max);
            root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIndex));
            root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIndex + 1, nums.length));

            return root;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new MaximumBinaryTree().new Solution();
        // put your test code here
        Integer[] nums = { 3, 2, 1, 6, 0, 5 };
        TreeNode result = solution
                .constructMaximumBinaryTree(Arrays.stream(nums).mapToInt(Integer::intValue).toArray());
        System.out.println(TreeNodeUtil.treeToString(result));
        // Expected output: [6,3,5,null,2,0,null,null,1]

    }
}

/*
 * // @lcpr case=start
 * // [3,2,1,6,0,5]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [3,2,1]\n
 * // @lcpr case=end
 * 
 */
