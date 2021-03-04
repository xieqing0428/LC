package cn.alessa0.lc.offer.q16;

/**
 * 剑指 Offer 16. 数值的整数次方
 * <p>
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/3/4 08:43
 */
public class Java {
    /**
     * 快速幂
     * Time  O(logn)
     * Space O(1)
     *
     * @param x 底
     * @param n 幂
     * @return 果
     */
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            // 十进制转二进制展开
            // 幂的二进制数当前位是否为1
            if ((i & 1) == 1) {
                res *= x;
            }
            x *= x;
        }
        return n >= 0 ? res : 1 / res;
    }
}