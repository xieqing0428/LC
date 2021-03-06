package cn.alessa0.lc.offer.q27

/**
 * 剑指 Offer 27. 二叉树的镜像
 * <p>
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
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
  def mirrorTree(root: TreeNode): TreeNode = {
    if (root == null || (root.left == null && root.right == null)) return root
    val tmp = mirrorTree(root.left)
    root.left = mirrorTree(root.right)
    root.right = tmp
    root
  }
}