package cn.alessa0.lc.offer.q04

/**
 * 剑指 Offer 04. 二维数组中的查找
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/12 16:36
 */
object Scala {

  /**
   * Time  O(nlogn)
   * Space O(1)
   *
   * @param matrix INPUT 0 <= n <= 1000;0 <= m <= 1000
   * @param target TARGET
   * @return boolean
   */
  def findNumberIn2DArray(matrix: Array[Array[Int]], target: Int): Boolean = {
    if (matrix == null || matrix.length < 1 || matrix(0) == null || matrix(0).length < 1) return false
    var row = 0
    var col = matrix(0).length - 1
    while (row < matrix.length && col >= 0) {
      if (matrix(row)(col) == target) return true
      if (matrix(row)(col) < target) row += 1
      else col -= 1
    }
    false
  }
}