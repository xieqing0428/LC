package cn.alessa0.lc.offer.q21

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * @author Alessa0
 * @since 2021/3/5 09:01
 * @version 0.0.1
 */
object Scala {
  /**
   * 双指针
   * Time  O(n)
   * Space O(1)
   *
   * @param nums 0 <= nums.length <= 50000;1 <= nums[i] <= 10000
   * @return 结果
   */
  def exchange(nums: Array[Int]): Array[Int] = {
    if (nums == null || nums.length <= 1) return nums
    var left = 0
    var right = nums.length - 1
    while (left < right) {
      while ((left < right) && (nums(left) & 1) == 1) left += 1
      while ((left < right) && (nums(right) & 1) == 0) right -= 1
      val tmp = nums(left)
      nums(left) = nums(right)
      nums(right) = tmp
    }
    nums
  }
}