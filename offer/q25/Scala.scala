package cn.alessa0.lc.offer.q25

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * <p>
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
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
   * @param l1 节点1 0 <= 链表长度 <= 1000
   * @param l2 节点2 0 <= 链表长度 <= 1000
   * @return 结果
   */
  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    val res = new ListNode(0)
    var l1tmp = l1
    var l2tmp = l2
    var cur = res
    while (l1tmp != null && l2tmp != null) {
      if (l1tmp.x < l2tmp.x) {
        cur.next = l1tmp
        l1tmp = l1tmp.next
      }
      else {
        cur.next = l2tmp
        l2tmp = l2tmp.next
      }
      cur = cur.next
    }
    cur.next = if (l1tmp == null) l2tmp else l1tmp
    res.next
  }
}