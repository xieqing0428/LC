package cn.alessa0.lc.offer.q19

/**
 * 剑指 Offer 19. 正则表达式匹配
 * <p>
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * <p>
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 *
 * @author Alessa0
 * @since 2021/3/5 09:01
 * @version 0.0.1
 */
object Scala {
  var cache: Array[Array[Int]] = _

  /**
   * Time  O(mn)
   * Space O(mn)
   *
   * @param s 字符串:可能为空，且只包含从 a-z 的小写字母。
   * @param p 模式:可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'
   * @return 结果--
   */
  def isMatch(s: String, p: String): Boolean = {
    val sArray = s.toCharArray
    val pArray = p.toCharArray
    cache = Array.ofDim(s.length + 1, p.length + 1)
    dfs(sArray, 0, pArray, 0)
  }

  def dfs(sArray: Array[Char], i: Int, pArray: Array[Char], j: Int): Boolean = {
    if (cache(i)(j) != 0) return cache(i)(j) == 1
    if (j == pArray.length) {
      cache(i)(j) = if (i == sArray.length) 1 else -1
      return i == sArray.length
    }
    val firstMatch = (i < sArray.length) && ((pArray(j) == '.') || (pArray(j) == sArray(i)))
    var `match` = false
    if (j + 1 < pArray.length && pArray(j + 1) == '*') `match` = if (firstMatch) dfs(sArray, i + 1, pArray, j) || dfs(sArray, i, pArray, j + 2) else dfs(sArray, i, pArray, j + 2)
    else `match` = firstMatch && dfs(sArray, i + 1, pArray, j + 1)
    cache(i)(j) = if (`match`) 1 else -1
    `match`
  }
}