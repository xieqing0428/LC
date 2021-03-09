package cn.alessa0.lc.offer.q35;

/**
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/3/9 17:55
 */
public class Node {
    int val;
    int value;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.value = val;
        this.next = null;
        this.random = null;
    }
}