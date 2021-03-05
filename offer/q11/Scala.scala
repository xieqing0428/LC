package cn.alessa0.lc.offer.q11

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * @author Alessa0
 * @since 2021/3/1 18:34
 * @version 0.0.1
 */
object Scala {
  /**
   * Time O(logn) ~ O(n)
   * Space O(1)
   *
   * @param numbers 入参数组
   * @return 数组最小值
   */
  def minArray(numbers: Array[Int]): Int = {
    if (numbers == null || numbers.length <= 0) return Integer.MIN_VALUE
    var left = 0
    var right = numbers.length - 1
    while (left < right && numbers(left) >= numbers(right)) {
      val mid = left + (right - left) / 2
      if (numbers(mid) < numbers(right)) right = mid
      else if (numbers(mid) > numbers(right)) left = mid + 1
      else right -= 1
    }
    numbers(left)
  }
}