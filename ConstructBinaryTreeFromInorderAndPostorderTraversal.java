/*
 * @lc app=leetcode.cn id=106 lang=java
 * @lcpr version=30202
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

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
        // 构造哈希映射，帮助我们快速定位根节点
        HashMap<Integer, Integer> valToIndex = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            for (int i = 0; i < inorder.length; i++) {
                valToIndex.put(inorder[i], i);
            }

            return build(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
        }

        TreeNode build(int[] postorder, int postStart, int postEnd,
                int[] inorder, int inStart, int inEnd) {
            if (postStart > postEnd) {
                return null;
            }

            int rootVal = postorder[postEnd];
            int index = valToIndex.get(rootVal);
            int leftSize = index - inStart;

            TreeNode root = new TreeNode(rootVal);
            root.left = build(postorder, postStart, postStart + leftSize - 1, inorder, inStart, index - 1);
            root.right = build(postorder, postStart + leftSize, postEnd - 1, inorder, index + 1, inEnd);

            return root;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        // put your test code here
        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };
        TreeNode root = solution.buildTree(inorder, postorder);
        System.out.println(TreeNodeUtil.treeToString(root));
        // Expected output: [3,9,20,null,null,15,7]
    }
}

/*
 * // @lcpr case=start
 * // [9,3,15,20,7]\n[9,15,7,20,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [-1]\n[-1]\n
 * // @lcpr case=end
 * 
 */
