package cn.alessa0.lc.offer.q32;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * <p>
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/13 18:12
 */
public class Java {
    /**
     * Time  O(n)
     * Space O(n)
     *
     * @param root 节点总数 <= 1000
     * @return 结果
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        int idx = 0;
        int[] res = new int[10007];
        Deque<TreeNode> tmp = new LinkedList<>();
        tmp.add(root);
        while (!tmp.isEmpty()) {
            TreeNode cur = tmp.poll();
            res[idx++] = cur.val;
            if (cur.left != null) {
                tmp.add(cur.left);
            }
            if (cur.right != null) {
                tmp.add(cur.right);
            }
        }
        return Arrays.copyOf(res, idx);
    }
}