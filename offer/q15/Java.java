package cn.alessa0.lc.offer.q15;

/**
 * 剑指 Offer 15. 二进制中1的个数
 * <p>
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。
 * <p>
 * 例如，把 9表示成二进制是 1001，有 2 位是 1。
 * 因此，如果输入 9，则该函数输出 2。
 * <p>
 * you need to treat n as an unsigned value
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/3/3 10:23
 */
public class Java {
    /**
     * Time  O(n)
     * Space O(1)
     *
     * @param n 入参 必须是长度为 32 的 二进制串
     * @return 结果
     */
    public int hammingWeight01(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    /**
     * Time  O(n)
     * Space O(1)
     *
     * @param n 入参 必须是长度为 32 的 二进制串
     * @return 结果
     */
    public int hammingWeight02(int n) {
        return Integer.bitCount(n);
    }
}