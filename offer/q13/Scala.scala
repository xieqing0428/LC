package cn.alessa0.lc.offer.q13

/**
 * @author Alessa0
 * @since 2021/3/2 18:33
 * @version 0.0.1
 */
object Scala {
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