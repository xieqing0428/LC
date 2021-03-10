package cn.alessa0.lc.offer.q37;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 37. 序列化二叉树
 * <p>
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/13 18:12
 */
public class Java {

    /**
     * Encodes a tree to a single string.
     * Time  O(n)
     * Space O(n)
     *
     * @param root 节点
     * @return 序列
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder res = new StringBuilder();
        res.append("[");
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                res.append(cur.val).append(",");
                queue.add(cur.left);
                queue.add(cur.right);
            } else {
                res.append("null,");
            }
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    /**
     * Decodes your encoded data to tree.
     * Time  O(n)
     * Space O(n)
     *
     * @param data 序列
     * @return 节点
     */
    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) {
            return null;
        }
        String[] val = data.substring(1, data.length() - 1).split(",");
        TreeNode res = new TreeNode(Integer.parseInt(val[0]));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(res);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (!"null".equals(val[i])) {
                cur.left = new TreeNode(Integer.parseInt(val[i]));
                queue.add(cur.left);
            }
            i++;
            if (!"null".equals(val[i])) {
                cur.right = new TreeNode(Integer.parseInt(val[i]));
                queue.add(cur.right);
            }
            i++;
        }
        return res;
    }
}