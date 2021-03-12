package cn.alessa0.lc.offer.q44;

/**
 * 剑指 Offer 44. 数字序列中某一位的数字
 * <p>
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/13 18:12
 */
public class Java {
    /**
     * Time  O(logn)
     * Space O(logn)
     *
     * @param n 0 <= n < 2<sup>31</sup>
     * @return max
     */
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        // 1.
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        // 2.
        long num = start + (n - 1) / digit;
        // 3.
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}