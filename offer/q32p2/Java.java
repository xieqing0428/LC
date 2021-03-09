package cn.alessa0.lc.offer.q32p2;

import java.util.*;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * <p>
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> tmp = new LinkedList<>();
        if (root != null) {
            tmp.add(root);
        }
        while (!tmp.isEmpty()) {
            List<Integer> resTmp = new ArrayList<>();
            for (int i = tmp.size(); i > 0; i--) {
                TreeNode cur = Objects.requireNonNull(tmp.poll());
                resTmp.add(cur.val);
                if (cur.left != null) {
                    tmp.add(cur.left);
                }
                if (cur.right != null) {
                    tmp.add(cur.right);
                }
            }
            res.add(resTmp);
        }
        return res;
    }
}