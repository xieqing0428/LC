package cn.alessa0.lc.offer.q29

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * <p>
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/13 18:12
 */
object Scala {

  /**
   * @param matrix 0 <= matrix.length <= 100;0 <= matrix[i].length <= 100
   * @return 结果
   */
  def spiralOrder(matrix: Array[Array[Int]]): Array[Int] = {
    if (matrix == null || matrix.length == 0 || matrix(0) == null || matrix(0).length == 0) return new Array[Int](0)
    var start = 0
    var index = 0
    val row = matrix.length
    val column = matrix(0).length
    val res = new Array[Int](row * column)
    while (row > 2 * start && column > 2 * start) {
      index = spiralOrder(matrix, start, res, index)
      start += 1
    }
    res
  }

  def spiralOrder(matrix: Array[Array[Int]], start: Int, res: Array[Int], index: Int): Int = {
    val endRow = matrix.length - 1 - start
    val endColumn = matrix(0).length - 1 - start
    var idx = index

    for (i <- start to endColumn) {
      res(idx) = matrix(start)(i)
      idx += 1
    }
    if (start < endRow) for (i <- start + 1 to endRow) {
      res(idx) = matrix(i)(endColumn)
      idx += 1
    }
    if (start < endRow && start < endColumn) for (i <- endColumn - 1 to start by -1) {
      res(idx) = matrix(endRow)(i)
      idx += 1
    }
    if (start < endRow - 1 && start < endColumn) for (i <- endRow - 1 until start by -1) {
      res(idx) = matrix(i)(start)
      idx += 1
    }
    idx
  }
}