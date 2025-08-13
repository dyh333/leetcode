/*
 * @lc app=leetcode.cn id=297 lang=java
 * @lcpr version=30202
 *
 * [297] 二叉树的序列化与反序列化
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SerializeAndDeserializeBinaryTree {

    // @lc code=start
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {
        String SEP = ",";
        String NULL = "#";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            
            // serialize(root, sb);

            sb.append(traverseSerialize(root));

            return sb.toString();
        }

        String traverseSerialize(TreeNode root) {
            if (root == null) {
                return NULL + SEP;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(root.val).append(SEP);
            sb.append(traverseSerialize(root.left));
            sb.append(traverseSerialize(root.right));
            return sb.toString();
        }

        void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NULL).append(SEP);
                return;
            }

            sb.append(root.val).append(SEP);

            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            LinkedList<String> nodes = new LinkedList<>();
            for (String s : data.split(SEP)) {
                nodes.add(s);
            }

            return deserialize(nodes);
        }

        TreeNode deserialize(LinkedList<String> nodes) {
            if (nodes.isEmpty())
                return null;

            String val = nodes.poll();
            if (val.equals(NULL))
                return null;

            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = deserialize(nodes);
            root.right = deserialize(nodes);
            return root;
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // TreeNode ans = deser.deserialize(ser.serialize(root));
    // @lc code=end

    public static void main(String[] args) {
        // put your test code here
        Codec codec = new SerializeAndDeserializeBinaryTree().new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialized = codec.serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode deserialized = codec.deserialize(serialized);
        System.out.println("Deserialized: " + codec.serialize(deserialized));
    }
}

/*
 * // @lcpr case=start
 * // [1,2,3,null,null,4,5]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2]\n
 * // @lcpr case=end
 * 
 */
