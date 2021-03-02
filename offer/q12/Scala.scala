package cn.alessa0.lc.offer.q12

/**
 * 剑指 Offer 12. 矩阵中的路径
 * <p>
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 *
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 * @author Alessa0
 * @since 2021/3/2 08:38
 * @version 0.0.1
 */
object Scala {
  def exist(board: Array[Array[Char]], word: String): Boolean = {
    val words = word.toCharArray
    for (i <- board.indices) {
      for (j <- board(0).indices) {
        if (dfs(board, words, i, j, 0)) return true
      }
    }
    false
  }

  def dfs(board: Array[Array[Char]], word: Array[Char], i: Int, j: Int, k: Int): Boolean = {
    if (i >= board.length || i < 0 || j >= board(0).length || j < 0 || board(i)(j) != word(k)) return false
    if (k == word.length - 1) return true
    board(i)(j) = '\u0000'
    val res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) || dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1)
    board(i)(j) = word(k)
    res
  }
}