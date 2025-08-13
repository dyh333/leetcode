package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class TreeNodeUtil {
    public static String treeToString(TreeNode root) {
        if (root == null) {
            return "[]";
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
        // 去除末尾多余的 null
        int i = result.size() - 1;
        while (i >= 0 && result.get(i).equals("null")) {
            i--;
        }
        result = result.subList(0, i + 1);
        return "[" + String.join(",", result) + "]";
    }

    public static TreeNode stringToTreeNode(String data) {
        if (data == null || data.equals("null")) {
            return null;
        }
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();
            if (!values[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.left);
            }
            i++;
            if (i < values.length && !values[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }     

}
