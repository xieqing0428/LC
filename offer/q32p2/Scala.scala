package cn.alessa0.lc.offer.q32p2

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * <p>
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
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
    while (tmp.nonEmpty) {
      val resTmp = new mutable.ListBuffer[Int]()
      for (_ <- tmp.size until 0 by -1) {
        val cur = tmp.dequeue()
        resTmp.addOne(cur.value)
        if (cur.left != null) tmp.enqueue(cur.left)
        if (cur.right != null) tmp.enqueue(cur.right)
      }
      res.addOne(resTmp.result())
    }
    res.result()
  }
}