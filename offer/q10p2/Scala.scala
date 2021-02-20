package cn.alessa0.lc.offer.q10p2

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * @author alessa0
 * @version 0.0.1
 * @since 2021/1/21 17:55
 */
object Scala {
  /**
   * Time O(2<sup>n</sup>)
   * Space O(1)
   *
   * @param n 第n项
   * @return 结果
   */
  def numWays01(n: Int): Int = {
    if (n < 2) return 1
    numWays01(n - 1) + numWays01(n - 2)
  }

  /**
   * Time O(n)
   * Space O(n)
   *
   * @param n 第n项
   * @return 结果
   */
  def numWays02(n: Int): Int = {
    if (n < 2) return 1
    val dp = new Array[Int](n + 1)
    dp(0) = 1
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
  def numWays03(n: Int): Int = {
    val mod = 1000000007
    var first = 1
    var second = 1
    var result = 0
    for (_ <- 2 to n) {
      result = (first + second) % mod
      second = first
      first = result
    }
    first
  }
}