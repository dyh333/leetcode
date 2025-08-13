/*
 * @lc app=leetcode.cn id=105 lang=java
 * @lcpr version=30202
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

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

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                valToIndex.put(inorder[i], i);
            }

            return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        // 定义：前序遍历数组为 preorder[preStart..preEnd]
        // 中序遍历数组为 inorder[inStart..inEnd]
        // 构造这个二叉树并返回该二叉树的根节点
        TreeNode build(int[] preorder, int preStart, int preEnd,
                int[] inorder, int inStart, int inEnd) {
            if (preStart > preEnd) {
                return null;
            }

            // root 节点对应的值就是前序遍历数组的第一个元素
            int rootVal = preorder[preStart];
            // rootVal 在中序遍历数组中的索引
            int index = valToIndex.get(rootVal);

            int leftSize = index - inStart;

            // 先构造出当前根节点
            TreeNode root = new TreeNode(rootVal);
            // 递归构造左右子树
            root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
            root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);

            return root;

        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        // put your test code here
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = solution.buildTree(preorder, inorder);
        System.out.println(TreeNodeUtil.treeToString(root));
    }
}

/*
 * // @lcpr case=start
 * // [3,9,20,15,7]\n[9,3,15,20,7]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [-1]\n[-1]\n
 * // @lcpr case=end
 * 
 */
