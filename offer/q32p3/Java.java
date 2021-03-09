package cn.alessa0.lc.offer.q32p3;

import java.util.*;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * <p>
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
        boolean mark = false;
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
            if (mark) {
                Collections.reverse(resTmp);
            }
            res.add(resTmp);
            mark = !mark;
        }
        return res;
    }
}