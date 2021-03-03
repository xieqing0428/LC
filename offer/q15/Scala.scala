package cn.alessa0.lc.offer.q15

/**
 * 剑指 Offer 15. 二进制中1的个数
 * <p>
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。
 * <p>
 * 例如，把 9表示成二进制是 1001，有 2 位是 1。
 * 因此，如果输入 9，则该函数输出 2。
 *
 * you need to treat n as an unsigned value
 *
 * @author Alessa0
 * @since 2021/3/3 10:23
 * @version 0.0.1
 */
object Scala {
  /**
   * Time  O(n)
   * Space O(1)
   *
   * @param n 入参
   * @return 结果
   */
  def hammingWeight(n: Int): Int = {
    var count = 0
    var temp = n
    while (temp != 0) {
      temp = temp & (temp - 1)
      count += 1
    }
    count
  }
}