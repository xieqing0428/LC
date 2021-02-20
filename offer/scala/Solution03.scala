package cn.alessa0.lc.offer.scala

import scala.collection.mutable

/**
 * 剑指 Offer 03. 数组中重复的数字
 *
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/11 18:48
 */
object Solution03 {

  /**
   * Time  O(nlogn)
   * Space O(1)
   *
   * @param nums INPUT[2, 3, 1, 0, 2, 5, 3]
   * @return int
   */
  def findRepeatNumber01(nums: Array[Int]): Int = {
    if (nums == null || nums.length < 2) return -1
    val sortedNums = nums.sorted
    for (i <- 0 until sortedNums.length - 1) {
      if (sortedNums(i) == sortedNums(i + 1)) return sortedNums(i)
    }
    -1
  }

  /**
   * Time  O(n)
   * Space O(n)
   *
   * @param nums INPUT[2, 3, 1, 0, 2, 5, 3]
   * @return int
   */
  def findRepeatNumber02(nums: Array[Int]): Int = {
    if (nums == null || nums.length < 2) return -1
    val result = new mutable.HashSet[Int]()
    nums.foreach(x => {
      if (result.contains(x)) {
        return x
      } else {
        result += x
      }
    })
    -1
  }

  /**
   * Time  O(n)
   * Space O(1)
   *
   * @param nums INPUT[2, 3, 1, 0, 2, 5, 3]
   * @return int
   */
  def findRepeatNumber03(nums: Array[Int]): Int = {
    if (nums == null || nums.length < 2) return -1
    for (i <- nums.indices) {
      while (nums(i) != i) {
        if (nums(nums(i)) == nums(i)) return nums(i)
        val temp = nums(i)
        nums(nums(i)) = temp
        nums(i) = nums(nums(i))
      }
    }
    -1
  }
}