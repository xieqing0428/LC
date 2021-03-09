package cn.alessa0.lc.offer.q33

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同。
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
   * @param postorder 数组长度 <= 1000
   * @return 结果
   */
  def verifyPostorder(postorder: Array[Int]): Boolean = {
    import scala.collection.mutable
    val stack = new mutable.Stack[Integer]
    var root: Int = Integer.MAX_VALUE
    for (i <- postorder.length - 1 to 0 by -1) {
      if (postorder(i) > root) return false
      while (stack.nonEmpty && stack.top > postorder(i)) root = stack.pop
      stack.push(postorder(i))
    }
    true
  }
}