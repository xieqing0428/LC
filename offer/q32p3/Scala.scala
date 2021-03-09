package cn.alessa0.lc.offer.q32p3

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * <p>
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/13 18:12
 */
object Scala {

  /**
   * Time  O(n)
   * Space O(n)
   *
   * @param root 节点总数 <= 1000
   * @return 结果
   */
  def levelOrder(root: TreeNode): List[List[Int]] = {
    import scala.collection.mutable
    val res = new mutable.ListBuffer[List[Int]]()
    val tmp = new mutable.Queue[TreeNode]()
    if (root != null) tmp.enqueue(root)
    var mark = false
    while (tmp.nonEmpty) {
      val resTmp = new mutable.ListBuffer[Int]()
      for (_ <- tmp.size until 0 by -1) {
        val cur = tmp.dequeue()
        resTmp.addOne(cur.value)
        if (cur.left != null) tmp.enqueue(cur.left)
        if (cur.right != null) tmp.enqueue(cur.right)
      }
      res.addOne(if (mark) resTmp.reverse.result() else resTmp.result())
      mark = !mark
    }
    res.result()
  }
}