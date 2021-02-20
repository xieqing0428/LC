package cn.alessa0.lc.offer.q03p2

/**
 * 剑指 Offer 03 Part II. 不修改数组找出重复的数字
 *
 * 在一个长度为 n+1 的数组里的所有数字都在 1～n 的范围内，所以数组中至少有一个数字是重复的。
 * 请找出数组中任意一个重复的数字，但不能修改输入的数组。
 * 例如，如果输入长度为8的数组{2，3，5，4，3，2，6，7}，那么对应的输出是重复的数字2或者3。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/11 18:48
 */
object Scala {
  /**
   * Time  O(n)
   * Space O(n)
   *
   * @param nums INPUT
   * @return int
   */
  def findRepeatNumber01(nums: Array[Int]): Int = {
    if (nums == null || nums.length < 2) return -1
    val temp = Array.fill(nums.length)(0)
    for (i <- nums.indices) {
      if (temp(nums(i)) == 1) {
        return nums(i)
      } else {
        temp(nums(i)) = 1
      }
    }
    -1
  }

  /**
   * Time  O(nlogn)
   * Space O(1)
   *
   * @param nums INPUT[2, 3, 1, 0, 2, 5, 3]
   * @return int
   */
  def findRepeatNumber02(nums: Array[Int]): Int = {
    if (nums == null || nums.length < 2) return -1
    var start = 1
    var end = nums.length - 1
    while (end >= start) {
      val middle = (start + end) >> 1
      val count = countRange(nums, start, middle)
      if (end == start) {
        return if (count > 1) count else -1
      }
      if (count > (middle - start + 1)) {
        end = middle
      } else {
        start = middle + 1
      }
    }
    -1
  }

  def countRange(nums: Array[Int], start: Int, middle: Int): Int = {
    var count = 0
    for (elem <- nums) {
      if (elem >= start && elem <= middle) {
        count += 1
      }
    }
    count
  }
}