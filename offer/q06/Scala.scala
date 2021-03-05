package cn.alessa0.lc.offer.q06

/**
 * 剑指 Offer 06. 从尾到头打印链表
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/12 18:06
 */
object Scala {
  /**
   * Time  O(n)
   * Space O(n)
   *
   * 0 <= 链表长度 <= 10000
   *
   * @param head Head Node
   * @return int[]
   */
  def reversePrint(head: ListNode): Array[Int] = {
    var node = head
    val re = scala.collection.mutable.Stack[Int]()
    while (node != null) {
      re.push(node.x)
      node = node.next
    }
    re.toArray
  }
}