package cn.alessa0.lc.offer.q13

/**
 * 剑指 Offer 13. 机器人的运动范围
 * <p>
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0]的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * <p>
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格[35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 *
 * @author Alessa0
 * @since 2021/3/2 18:33
 * @version 0.0.1
 */
object Scala {
  /**
   * Time  O(mn)
   * Space O(mn)
   *
   * @param m 横坐标
   * @param n 纵坐标
   * @param k 总数
   * @return 结果
   */
  def movingCount(m: Int, n: Int, k: Int): Int = {
    val visited = Array.fill(m + 1, n + 1)(false)
    dfs(visited, m, n, k, 0, 0)
  }

  def dfs(visited: Array[Array[Boolean]], m: Int, n: Int, k: Int, i: Int, j: Int): Int = {
    if (i < 0 || i >= m || j < 0 || j >= n || visited(i)(j) || sum(i) + sum(j) > k) return 0
    visited(i)(j) = true
    1 + dfs(visited, m, n, k, i + 1, j) + dfs(visited, m, n, k, i, j + 1)
  }

  def sum(x: Int): Int = {
    var sum = 0
    var tempX = x
    while (tempX > 0) {
      sum += tempX % 10
      tempX /= 10
    }
    sum
  }
}