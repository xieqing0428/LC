package cn.alessa0.lc.offer.q09

/**
 * 剑指 Offer 09. 用两个栈实现队列
 *
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead操作返回 -1 )
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/20 16:01
 */
class Scala {

  import scala.collection.mutable

  private val in = new mutable.Stack[Int]()
  private val out = new mutable.Stack[Int]()

  /**
   * 最多会对 appendTail、deleteHead 进行 10000 次调用
   *
   * @param value 1 <= values <= 10000
   */
  def appendTail(value: Int): Unit = {
    in.push(value)
  }

  def deleteHead(): Int = {
    if (out.isEmpty) {
      if (in.isEmpty) return -1
      while (in.nonEmpty) out.push(in.pop)
    }
    out.pop
  }
}