package cn.alessa0.lc.offer.q18

/**
 * 剑指 Offer 18. 删除链表的节点
 * <p>
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * <p>
 * 注意：此题对比原题有改动
 *
 * @author Alessa0
 * @since 2021/3/4 10:52
 * @version 0.0.1
 */
object Scala {
  /**
   * Time  O(n)
   * Space O(1)
   *
   * @param head 头节点
   * @param val  要删除节点的值
   * @return 头节点
   */
  def deleteNode(head: ListNode, `val`: Int): ListNode = {
    if (head == null) return null
    if (head.x == `val`) return head.next
    var pre = head
    var cur = head.next
    while (cur != null && cur.x != `val`) {
      pre = cur
      cur = cur.next
    }
    if (cur != null) pre.next = cur.next
    head
  }
}