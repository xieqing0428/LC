package cn.alessa0.lc.offer.q31

/**
 * 剑指 Offer 31. 栈的压入、弹出序列
 * <p>
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * <p>
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/13 18:12
 */
object Scala {

  /**
   * pushed 是 popped 的排列
   * Time  O(n)
   * Space O(1)
   *
   * @param pushed 0 <= pushed.length == popped.length <= 1000;0 <= pushed[i], popped[i] < 1000
   * @param popped 0 <= pushed.length == popped.length <= 1000;0 <= pushed[i], popped[i] < 1000
   * @return 结果
   */
  def validateStackSequences(pushed: Array[Int], popped: Array[Int]): Boolean = {
    var i = 0
    var j = 0
    for (element <- pushed) {
      pushed(i) = element
      while (i >= 0 && pushed(i) == popped(j)) {
        i -= 1
        j += 1
      }
      i += 1
    }
    i == 0
  }
}