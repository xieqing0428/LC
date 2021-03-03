package cn.alessa0.lc.offer.q14p2

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
   * 贪心
   * Time  O(n)
   * Space O(1)
   *
   * @param n 入参
   * @return 结果
   */
  def cuttingRope01(n: Int): Int = {
    if (n <= 3) return n - 1
    val mod = 1000000007
    var result = 1L
    var temp = n
    while (temp >= 5) {
      result = result * 3 % mod
      temp -= 3
    }
    (result * n % mod).toInt
  }


  /**
   * 贪心
   * Time  O(logn)
   * Space O(1)
   *
   * @param n 入参
   * @return 结果
   */
  def cuttingRope02(n: Int): Int = {
    if (n <= 3) return n - 1
    val mod = 1000000007
    val b = n % 3
    var result = 1L
    var x = 3L
    var a = n / 3 - 1
    while (a > 0) {
      if (a % 2 == 1) result = (result * x) % mod
      x = (x * x) % mod
      a /= 2
    }
    b match {
      case 0 => (result * 3 % mod).toInt
      case 1 => (result * 4 % mod).toInt
      case _ => (result * 6 % mod).toInt
    }
  }
}