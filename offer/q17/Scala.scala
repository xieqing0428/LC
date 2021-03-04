package cn.alessa0.lc.offer.q17

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 * <p>
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * @author Alessa0
 * @since 2021/3/4 09:24
 * @version 0.0.1
 */
object Scala {
  /**
   * Time  O(10^n)
   * Space O(10^n)
   *
   * @param n 入参
   * @return 结果
   */
  def printNumbers(n: Int): Array[Int] = (1 until math.pow(10, n).toInt).toArray
}