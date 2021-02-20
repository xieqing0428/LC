package cn.alessa0.lc.offer.q07;

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
public class TreeNode {
    public int val;
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        this.val = x;
        this.value = x;
    }
}