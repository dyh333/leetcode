/*
 * @lc app=leetcode.cn id=538 lang=java
 * @lcpr version=30203
 *
 * [538] 把二叉搜索树转换为累加树
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ConvertBstToGreaterTree {

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
        int sum = 0;

        public TreeNode convertBST(TreeNode root) {
            traverse(root);
            return root;
        }

        void traverse(TreeNode root) {
            if (root == null) {
                return;
            }

            traverse(root.right);

            sum += root.val;
            root.val = sum;

            traverse(root.left);
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new ConvertBstToGreaterTree().new Solution();
        // put your test code here
        Integer[] root = new Integer[] { 4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8 };
        TreeNode treeNode = TreeNode.createRoot(root);

        TreeNode res = solution.convertBST(treeNode);

        printFlattenedTree(res);
    }

    private static void printFlattenedTree(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.add("null");
            } else {
                result.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        // 去除末尾的 null
        while (!result.isEmpty() && result.get(result.size() - 1).equals("null")) {
            result.remove(result.size() - 1);
        }
        System.out.println("[" + String.join(",", result) + "]");
    }
}

/*
 * // @lcpr case=start
 * // [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0,null,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,0,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [3,2,4,1]\n
 * // @lcpr case=end
 * 
 */
