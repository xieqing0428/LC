package cn.alessa0.lc.offer.q41

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
class Scala {

  import scala.collection.mutable

  var left = new mutable.PriorityQueue[Int]()
  var right = new mutable.PriorityQueue[Int]()((v1: Int, v2: Int) => v2 - v1)

  /**
   * Time  O(logn)
   * Space O(n)
   */
  def addNum(num: Int): Unit = {
    if (left.isEmpty || num < left.head) {
      left.enqueue(num)
      if (left.size > right.size + 1) right.enqueue(left.dequeue())
    }
    else if (num == left.head)
      if (left.size > right.size) right.enqueue(num) else left.enqueue(num)
    else {
      right.enqueue(num)
      if (right.size > left.size + 1) left.enqueue(right.dequeue())
    }
  }

  /**
   * Time  O(1)
   * Space O(n)
   */
  def findMedian(): Double = {
    if (left.size > right.size) return left.head.doubleValue()
    else if (left.size < right.size) return right.head.doubleValue()
    (left.head + right.head) / 2.0
  }
}