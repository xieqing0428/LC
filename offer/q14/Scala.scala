package cn.alessa0.lc.offer.q14

/**
 * 剑指 Offer 14- I. 剪绳子
 * <p>
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1]可能的最大乘积是多少？
 * <p>
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * @author Alessa0
 * @since 2021/3/3 08:30
 * @version 0.0.1
 */
object Scala {
  /**
   * 动态规划
   * Time  O(n)
   * Space O(n)
   *
   * @param n 入参 2 <= n <= 58
   * @return 结果
   */
  def cuttingRope01(n: Int): Int = {
    if (n <= 3) return n - 1
    val dp = new Array[Int](n + 1)
    work(n, dp)
  }

  private def work(n: Int, dp: Array[Int]): Int = {
    if (n == 1) return 1
    if (dp(n) != 0) return dp(n)
    var max = Integer.MIN_VALUE
    for (i <- 1 until n) {
      max = Math.max(max, Math.max(i * work(n - i, dp), n))
    }
    dp(n) = max
    dp(n)
  }


  /**
   * 贪心
   * Time  O(n)
   * Space O(1)
   *
   * @param n 入参 2 <= n <= 58
   * @return 结果
   */
  def cuttingRope02(n: Int): Int = {
    if (n <= 3) return n - 1
    var result = 1
    var temp = n
    while (temp >= 5) {
      result *= 3
      temp -= 3
    }
    temp * result
  }

  /**
   * 贪心II
   * Time  O(1)
   * Space O(1)
   *
   * @param n 入参 2 <= n <= 58
   * @return 结果
   */
  def cuttingRope03(n: Int): Int = {
    if (n <= 3) return n - 1
    val a = n / 3
    val b = n % 3
    if (b == 0) return math.pow(3, a).toInt
    if (b == 1) return math.pow(3, a - 1).toInt * 4
    math.pow(3, a).toInt * 2
  }
}