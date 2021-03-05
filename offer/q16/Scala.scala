package cn.alessa0.lc.offer.q16

/**
 * 剑指 Offer 16. 数值的整数次方
 * <p>
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 *
 * @author Alessa0
 * @since 2021/3/4 08:43
 * @version 0.0.1
 */
object Scala {
  /**
   * 快速幂
   * Time  O(logn)
   * Space O(1)
   *
   * @param x 底 -100.0 < x < 100.0
   * @param n 幂 n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1]
   * @return 果
   */
  def myPow(x: Double, n: Int): Double = {
    if (x == 0) return 0
    var res = 1d
    var i = n
    var t = x
    while (i != 0) {
      if ((i & 1) == 1) res *= t
      t *= t
      i /= 2
    }
    if (n >= 0) res
    else 1 / res
  }
}