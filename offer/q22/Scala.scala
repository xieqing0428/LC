package cn.alessa0.lc.offer.q22

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * <p>
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 * @author Alessa0
 * @since 2021/3/5 09:01
 * @version 0.0.1
 */
object Scala {
  /**
   * 双指针
   * Time  O(n)
   * Space O(1)
   *
   * @param head 头节点
   * @param k    倒数第k位
   * @return 结果
   */
  def getKthFromEnd(head: ListNode, k: Int): ListNode = {
    if (head == null) return null
    var cur = head
    var res = head
    for (_ <- 1 to k) cur = cur.next
    while (cur != null) {
      cur = cur.next
      res = res.next
    }
    res
  }
}