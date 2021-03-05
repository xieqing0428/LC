package cn.alessa0.lc.offer.q20

/**
 * 剑指 Offer 20. 表示数值的字符串
 * <p>
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * <p>
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 *
 * @author Alessa0
 * @since 2021/3/5 09:01
 * @version 0.0.1
 */
object Scala {
  /**
   * Time  O(n)
   * Space O(1)
   *
   * @param s 字符串
   * @return 结果
   */
  def isNumber01(s: String): Boolean = {
    if (s == null || s.isEmpty) return false
    //去掉首位空格
    val t = s.trim
    var num = false
    var dot = false
    var e = false
    for (i <- 0 until t.length) {
      val tmp = t.charAt(i)
      tmp match {
        // 判定为数字，则标记num
        case tmp if '0' to '9' contains tmp => num = true
        // 判定为.  需要没出现过.并且没出现过e
        case '.' if !dot && !e => dot = true
        // 判定为e，需要没出现过e，并且出过数字了
        case 'e' | 'E' if !e && num =>
          e = true
          // 为了避免123e这种请求，出现e之后就标志为false
          num = false
        // 判定为+-符号，只能出现在第一位或者紧接e后面
        case '+' | '-' if i == 0 || t.charAt(i - 1) == 'e' || t.charAt(i - 1) == 'E' =>
        case _ => return false
      }
    }
    num
  }

  var index = 0

  /**
   * Time  O(n)
   * Space O(1)
   *
   * @param s 字符串
   * @return 结果
   */
  def isNumber02(s: String): Boolean = {
    if (s == null || s.isEmpty) return false
    index = 0
    val str = s.trim + "|"
    var numberic = scanInteger(str)
    if (str(index) == '.') {
      index += 1
      numberic = scanUnsignedInteger(str) || numberic
    }
    if (str(index) == 'e' || str(index) == 'E') {
      index += 1
      numberic = scanInteger(str) && numberic
    }
    while (str(index) == ' ') {
      index += 1
    }
    numberic && str(index) == '|'
  }

  def scanInteger(str: String): Boolean = {
    if (str(index) == '+' || str(index) == '-') index += 1
    scanUnsignedInteger(str)
  }

  def scanUnsignedInteger(str: String): Boolean = {
    val before = index
    while (str(index) >= '0' && str(index) <= '9') {
      index += 1
    }
    index > before
  }
}