package cn.alessa0.lc.offer.q40

/**
 * 剑指 Offer 40. 最小的k个数
 * <p>
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * <p>
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
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
   * @param arr 0 <= arr[i] <= 10000
   * @param k   0 <= k <= arr.length <= 10000
   * @return 结果
   */
  def getLeastNumbers01(arr: Array[Int], k: Int): Array[Int] = {
    val sorted = arr.sorted
    val ret: Array[Int] = Array.ofDim(k)
    0 until k foreach {
      i => ret(i) = sorted(i)
    }
    ret
  }

  /**
   * Time  O(nlogn)
   * Space O(k)
   *
   * @param arr 0 <= arr[i] <= 10000
   * @param k   0 <= k <= arr.length <= 10000
   * @return 结果
   */
  def getLeastNumbers02(arr: Array[Int], k: Int): Array[Int] = {
    import scala.collection.mutable
    if (k == 0) return new Array[Int](0)
    val max = new mutable.PriorityQueue[Int]()((v1: Int, v2: Int) => v2 - v1)
    for (i <- arr) {
      if (max.size < k) max.enqueue(i)
      else if (max.head > i) {
        max.dequeue()
        max.enqueue(i)
      }
    }
    max.toArray
  }

  /**
   * Time  O(n)
   * Space O(k)
   *
   * @param arr 0 <= arr[i] <= 10000
   * @param k   0 <= k <= arr.length <= 10000
   * @return 结果
   */
  def getLeastNumbers03(arr: Array[Int], k: Int): Array[Int] = {
    if (k >= arr.length) return arr
    quickSort(arr, k, 0, arr.length - 1)
  }

  private def quickSort(arr: Array[Int], k: Int, l: Int, r: Int): Array[Int] = {
    var i = l
    var j = r
    while (i < j) {
      while (i < j && arr(j) >= arr(l)) j -= 1
      while (i < j && arr(i) <= arr(l)) i += 1
      swap(arr, i, j)
    }
    swap(arr, i, l)
    if (i > k) return quickSort(arr, k, l, i - 1)
    if (i < k) return quickSort(arr, k, i + 1, r)
    Array.copyOf(arr, k)
  }

  private def swap(arr: Array[Int], i: Int, j: Int): Unit = {
    val tmp = arr(i)
    arr(i) = arr(j)
    arr(j) = tmp
  }
}