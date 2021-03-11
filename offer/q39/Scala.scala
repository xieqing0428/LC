package cn.alessa0.lc.offer.q39

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/13 18:12
 */
object Scala {
  /**
   * Time  O(nlogn)
   * Space O(logn)
   *
   * @param nums 1 <= 数组长度 <= 50000
   * @return 中位数
   */
  def majorityElement01(nums: Array[Int]): Int = {
    import scala.util.Sorting.quickSort
    quickSort(nums)
    nums(nums.length / 2)
  }

  /**
   * Time  O(n)
   * Space O(1)
   *
   * @param nums 1 <= 数组长度 <= 50000
   * @return 中位数
   */
  def majorityElement02(nums: Array[Int]): Int = {
    var card = 0
    var count = 0
    for (i <- nums) {
      if (count == 0) card = i
      count += (if (card == i) 1 else -1)
    }
    card
  }
}