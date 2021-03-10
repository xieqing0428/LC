package cn.alessa0.lc.offer.q37

/**
 * 剑指 Offer 37. 序列化二叉树
 * <p>
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/13 18:12
 */
class Scala {
  /**
   * Encodes a tree to a single string.
   * Time  O(n)
   * Space O(n)
   *
   * @param root 节点
   * @return 序列
   */
  def serialize(root: TreeNode): String = {
    import scala.collection.mutable
    if (root == null) return "[]"
    val res: mutable.StringBuilder = null
    res.append("[")
    val queue = new mutable.Queue[TreeNode]
    queue.enqueue(root)
    while (queue.nonEmpty) {
      val cur = queue.dequeue()
      if (cur != null) {
        res.append(cur.value).append(",")
        queue.enqueue(cur.left)
        queue.enqueue(cur.right)
      }
      else res.append("null,")
    }
    res.deleteCharAt(res.length - 1)
    res.append("]")
    res.toString
  }

  /**
   * Decodes your encoded data to tree.
   * Time  O(n)
   * Space O(n)
   *
   * @param data 序列
   * @return 节点
   */
  def deserialize(data: String): TreeNode = {
    if (data == "[]") return null
    import scala.collection.mutable
    val values = data.substring(1, data.length - 1).split(",")
    val res = new TreeNode(values(0).toInt)
    val queue = new mutable.Queue[TreeNode]
    queue.enqueue(res)
    var i = 1
    while (queue.nonEmpty) {
      val cur = queue.dequeue()
      if ("null" != values(i)) {
        cur.left = new TreeNode(values(i).toInt)
        queue.enqueue(cur.left)
      }
      i += 1
      if ("null" != values(i)) {
        cur.right = new TreeNode(values(i).toInt)
        queue.enqueue(cur.right)
      }
      i += 1
    }
    res
  }
}