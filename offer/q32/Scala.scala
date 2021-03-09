package cn.alessa0.lc.offer.q32

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * <p>
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
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
  def levelOrder(root: TreeNode): Array[Int] = {
    import scala.collection.mutable
    if (root == null) return Array()
    val res = new mutable.ListBuffer[Int]()
    val queue = new mutable.Queue[TreeNode]()
    queue.enqueue(root)
    while (queue.nonEmpty) {
      val root = queue.dequeue()
      res += root.value
      if (root.left != null) queue.enqueue(root.left)
      if (root.right != null) queue.enqueue(root.right)
    }
    res.toArray
  }
}