package cn.alessa0.lc.offer.q41;

import java.util.PriorityQueue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 * <p>
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * <p>
 * 例如，[2,3,4] 的中位数是 3; [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/13 18:12
 */
public class Java {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public Java() {
        this.left = new PriorityQueue<>((v1, v2) -> v2 - v1);
        this.right = new PriorityQueue<>();
    }

    /**
     * Time  O(logn)
     * Space O(n)
     */
    public void addNum(int num) {
        Integer lp = left.peek();
        if (lp == null || num < lp) {
            left.add(num);
            if (left.size() > right.size() + 1) {
                right.add(left.poll());
            }
        } else if (num == lp) {
            if (left.size() > right.size()) {
                right.add(num);
            } else {
                left.add(num);
            }
        } else {
            right.add(num);
            if (right.size() > left.size() + 1) {
                left.add(right.poll());
            }
        }
    }

    /**
     * Time  O(1)
     * Space O(n)
     */
    public double findMedian() {
        if (left.size() > right.size()) {
            return left.peek();
        } else if (left.size() < right.size()) {
            return right.peek();
        }
        assert left.peek() != null;
        assert right.peek() != null;
        return (left.peek() + right.peek()) / 2.0;
    }
}