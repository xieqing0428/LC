package cn.alessa0.lc.offer.q24

/**
 * 剑指 Offer 24. 反转链表
 * <p>
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * @author Alessa0
 * @since 2021/3/5 09:01
 * @version 0.0.1
 */
object Scala {
  /**
   * Time  O(n)
   * Space O(1)
   *
   * @param head 头节点 0 <= 节点个数 <= 5000
   * @return 结果
   */
  def reverseList(head: ListNode): ListNode = {
    var res: ListNode = null
    var cur = head
    while (cur != null) {
      val tmp = cur.next
      cur.next = res
      res = cur
      cur = tmp
    }
    res
  }
}