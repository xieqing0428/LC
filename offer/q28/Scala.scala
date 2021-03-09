package cn.alessa0.lc.offer.q28

/**
 * 剑指 Offer 28. 对称的二叉树
 * <p>
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/13 18:12
 */
object Scala {
  /**
   * @param root 0 <= 节点个数 <= 1000
   * @return 结果
   */
  def isSymmetric(root: TreeNode): Boolean = {
    root == null || isSymmetric(root.left, root.right)
  }

  def isSymmetric(left: TreeNode, right: TreeNode): Boolean = {
    if (left == null && right == null) return true
    if (left == null || right == null || (left.value != right.value)) return false
    isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left)
  }
}