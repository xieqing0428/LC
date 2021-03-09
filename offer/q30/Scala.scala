package cn.alessa0.lc.offer.q30

/**
 * 剑指 Offer 30. 包含min函数的栈
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 * 各函数的调用总次数不超过 20000 次
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/13 18:12
 */
class Scala {

  import scala.collection.mutable

  private val data = new mutable.Stack[Integer]
  private val mini = new mutable.Stack[Integer]

  def push(x: Int): Unit = {
    data.push(x)
    if (mini.isEmpty || mini.top >= x) mini.push(x)
  }

  def pop(): Unit = {
    if (data.pop == mini.top) mini.pop
  }

  def top: Int = data.top

  def min: Int = mini.top
}