package cn.alessa0.lc.offer.q05

/**
 * 剑指 Offer 05. 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/12 17:21
 */
object Scala {
  /**
   * @param s INPUT
   * @return
   */
  def replaceSpace01(s: String): String = {
    s.replaceAll(" ", "%20")
  }

  /**
   * Time  O(n)
   * Space O(n)
   * 0 <= s 的长度 <= 10000
   * @param s INPUT
   * @return
   */
  def replaceSpace02(s: String): String = {
    val result = new StringBuilder
    s.foreach {
      case ' ' => result.append("%20")
      case x => result.append(x)
    }
    result.toString()
  }
}