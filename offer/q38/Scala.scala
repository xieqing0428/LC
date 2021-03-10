package cn.alessa0.lc.offer.q38

/**
 * 剑指 Offer 38. 字符串的排列
 * <p>
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/13 18:12
 */
object Scala {

  import scala.collection.mutable.ArrayBuffer

  private var chars: Array[Char] = _
  private var res: ArrayBuffer[String] = _

  def permutation(s: String): Array[String] = {
    chars = s.toCharArray
    res = new ArrayBuffer[String]()
    dfs(0)
    res.toArray
  }

  private def dfs(idx: Int): Unit = {
    if (idx == chars.length - 1) {
      res.append(chars.mkString(""))
      return
    }
    for (i <- idx until chars.length) {
      var mark = true
      for (j <- idx until i) {
        if (chars(i) == chars(j)) {
          mark = false
        }
      }
      if (mark) {
        swap(i, idx)
        dfs(idx + 1)
        swap(i, idx)
      }
    }
  }

  private def swap(i: Int, idx: Int): Unit = {
    if (i == idx) return
    val tmp = chars(i)
    chars(i) = chars(idx)
    chars(idx) = tmp
  }
}