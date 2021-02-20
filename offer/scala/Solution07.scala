package cn.alessa0.lc.offer.scala

import scala.collection.mutable


/**
 * 剑指 Offer 07. 重建二叉树
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/13 18:12
 */
object Solution07 {
  /**
   * Time  O(n)
   * Space O(n)
   *
   * @param preorder Pre
   * @param inorder  In
   * @return cn.alessa0.offer.java.TreeNode
   */
  def buildTree01(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null
    var pre = 0
    var in = 0

    def build01(preorder: Array[Int], inorder: Array[Int], stop: Int): TreeNode = {
      if (pre >= preorder.length) return null
      if (inorder(in) == stop) {
        in += 1
        return null
      }
      val node = new TreeNode(preorder(pre))
      pre += 1
      node.left = build01(preorder, inorder, node.value)
      node.right = build01(preorder, inorder, stop)
      node
    }

    build01(preorder, inorder, Int.MinValue)
  }


  /**
   * Time  O(n)
   * Space O(n)
   *
   * @param preorder Pre
   * @param inorder  In
   * @return cn.alessa0.offer.java.TreeNode
   */
  def buildTree02(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null
    val stack = new mutable.Stack[TreeNode]
    var inorderIndex = 0
    val root = new TreeNode(preorder(0))
    stack.push(root)
    for (i <- 1 until preorder.length) {
      var node = stack.top
      if (inorder(inorderIndex) != node.value) {
        node.left = new TreeNode(preorder(i))
        stack.push(node.left)
      } else {
        while (stack.nonEmpty && stack.top.value == inorder(inorderIndex)) {
          node = stack.pop()
          inorderIndex += 1
        }
        node.right = new TreeNode(preorder(i))
        stack.push(node.right)
      }
    }
    root
  }
}

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = _
  var right: TreeNode = _
}