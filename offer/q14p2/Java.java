package cn.alessa0.lc.offer.q14p2;

/**
 * 剑指 Offer 14- I. 剪绳子
 * <p>
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1]可能的最大乘积是多少？
 * <p>
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/3/3 08:30
 */
public class Java {
    /**
     * 贪心
     * Time  O(n)
     * Space O(1)
     *
     * @param n 入参 2 <= n <= 1000
     * @return 结果
     */
    public int cuttingRope01(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int mod = 1000000007;
        long result = 1L;
        while (n >= 5) {
            result = result * 3 % mod;
            n -= 3;
        }
        return (int) (result * n % mod);
    }

    /**
     * 贪心II
     * Time  O(logn)
     * Space O(1)
     *
     * @param n 入参 2 <= n <= 1000
     * @return 结果
     */
    public int cuttingRope02(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int mod = 1000000007;
        int b = n % 3;
        long result = 1L, x = 3;
        for (int a = n / 3 - 1; a > 0; a /= 2) {
            if (a % 2 == 1) {
                result = (result * x) % mod;
            }
            x = (x * x) % mod;
        }
        if (b == 0) {
            return (int) (result * 3 % mod);
        }
        if (b == 1) {
            return (int) (result * 4 % mod);
        }
        return (int) (result * 6 % mod);
    }
}