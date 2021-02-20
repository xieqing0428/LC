package cn.alessa0.lc.offer.java;

import java.util.Stack;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * <p>
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/12 17:56
 */
public class Solution06 {

    /**
     * Time  O(n)
     * Space O(n)
     *
     * @param head Head Node
     * @return int[]
     */
    public int[] reversePrint01(ListNode head) {
        ListNode current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }
        int[] result = new int[size];
        current = head;
        while (current != null) {
            result[--size] = current.val;
            current = current.next;
        }
        return result;
    }

    /**
     * Time  O(n)
     * Space O(n)
     *
     * @param head Head Node
     * @return int[]
     */
    public int[] reversePrint02(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) { val = x; }
}