package cn.alessa0.lc.offer.q25;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * <p>
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/3/5 09:01
 */
public class Java {
    /**
     * Time  O(n)
     * Space O(1)
     *
     * @param l1 节点1 0 <= 链表长度 <= 1000
     * @param l2 节点2 0 <= 链表长度 <= 1000
     * @return 结果
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return res.next;
    }
}