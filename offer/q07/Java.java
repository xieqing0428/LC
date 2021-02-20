package cn.alessa0.lc.offer.q07;

import java.util.Stack;

/**
 * 剑指 Offer 07. 重建二叉树
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/13 18:12
 */
public class Java {
    private int pre = 0;
    private int in = 0;

    /**
     * Time  O(n)
     * Space O(n)
     *
     * @param preorder Pre
     * @param inorder  In
     * @return cn.alessa0.offer.java.TreeNode
     */
    public TreeNode buildTree01(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        return build01(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode build01(int[] preorder, int[] inorder, int stop) {
        if (pre >= preorder.length) {
            return null;
        }
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre++]);
        root.left = build01(preorder, inorder, root.val);
        root.right = build01(preorder, inorder, stop);
        return root;
    }

    /**
     * Time  O(n)
     * Space O(n)
     *
     * @param preorder Pre
     * @param inorder  In
     * @return cn.alessa0.offer.java.TreeNode
     */
    public TreeNode buildTree02(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int length = preorder.length;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}