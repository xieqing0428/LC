package cn.alessa0.lc.offer.q26

/**
 * 剑指 Offer 26. 树的子结构
 * <p>
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/13 18:12
 */
object Scala {
  /**
   * @param A 0 <= 节点个数 <= 10000
   * @param B 0 <= 节点个数 <= 10000
   * @return 结果
   */
  def isSubStructure(A: TreeNode, B: TreeNode): Boolean = A != null && B != null && (listTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B))

  private def listTree(A: TreeNode, B: TreeNode): Boolean = {
    if (B == null) return true
    if (A == null || (A.value != B.value)) return false
    listTree(A.left, B.left) && listTree(A.right, B.right)
  }
}