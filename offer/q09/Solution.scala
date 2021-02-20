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
object Solution {
  def doSomething(): Unit = {
    val java = new Java
    java.appendTail(1)
    java.deleteHead()

    val scala = new Scala
    scala.appendTail(1)
    scala.deleteHead()
  }
}