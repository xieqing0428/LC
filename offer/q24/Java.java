package cn.alessa0.lc.offer.q24;

/**
 * 剑指 Offer 24. 反转链表
 * <p>
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
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
     * @param head 头节点 0 <= 节点个数 <= 5000
     * @return 结果
     */
    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = res;
            res = cur;
            cur = tmp;
        }
        return res;
    }
}