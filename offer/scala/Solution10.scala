package cn.alessa0.lc.offer.scala

/**
 *
 * @author alessa0
 * @version 0.0.1
 * @since 2021/1/21 17:55
 */
object Solution10 {
  /**
   * Time O(2<sup>n</sup>)
   * Space O(1)
   *
   * @param n 第n项
   * @return 结果
   */
  def fib01(n: Int): Int = {
    if (n == 0 || n == 1) return n
    fib01(n - 1) + fib01(n - 2)
  }

  /**
   * Time O(n)
   * Space O(n)
   *
   * @param n 第n项
   * @return 结果
   */
  def fib02(n: Int): Int = {
    if (n == 0 || n == 1) return n
    val dp = new Array[Int](n + 1)
    dp(0) = 0
    dp(1) = 1
    for (i <- 2 to n) {
      dp(i) = dp(i - 1) + dp(i - 2)
      dp(i) %= 1000000007
    }
    dp(n)
  }

  /**
   * Time O(n)
   * Space O(1)
   *
   * @param n 第n项
   * @return 结果
   */
  def fib03(n: Int): Int = {
    val mod = 1000000007
    var first = 1
    var second = 0
    var result = 0
    for (_ <- 0 until n) {
      result = (first + second) % mod
      second = first
      first = result
    }
    second
  }
}