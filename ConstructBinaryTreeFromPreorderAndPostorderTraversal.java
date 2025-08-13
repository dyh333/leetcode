/*
 * @lc app=leetcode.cn id=889 lang=java
 * @lcpr version=30202
 *
 * [889] 根据前序和后序遍历构造二叉树
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

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

        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            for (int i = 0; i < postorder.length; i++) {
                valToIndex.put(postorder[i], i);
            }

            return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
        }

        TreeNode build(int[] preorder, int preStart, int preEnd,
                int[] postorder, int postStart, int postEnd) {
            if (preStart > preEnd || postStart > postEnd) {
                return null;
            }
            // 根节点的值就是前序遍历数组的第一个元素
            int rootVal = preorder[preStart];
            // 如果只有一个节点，直接返回
            if (preStart == preEnd) {
                return new TreeNode(rootVal);
            }

            // 在后序遍历数组中找到根节点的下一个节点
            int nextRootVal = preorder[preStart + 1];
            int nextRootIndex = valToIndex.get(nextRootVal);

            // 计算左子树的大小
            int leftSize = nextRootIndex - postStart + 1;

            // 构造左子树和右子树
            TreeNode root = new TreeNode(rootVal);
            root.left = build(preorder, preStart + 1, preStart + leftSize,
                    postorder, postStart, nextRootIndex);
            root.right = build(preorder, preStart + leftSize + 1, preEnd,
                    postorder, nextRootIndex + 1, postEnd - 1);

            return root;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();
        // put your test code here
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};
        TreeNode root = solution.constructFromPrePost(preorder, postorder);
        System.out.println(TreeNodeUtil.treeToString(root));
        // Expected output: [1,2,3,4,5,null,null,6,7]
    }
}

/*
 * // @lcpr case=start
 * // [1,2,4,5,3,6,7]\n[4,5,2,6,7,3,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n[1]\n
 * // @lcpr case=end
 * 
 */
