package cn.alessa0.lc.offer.q10;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * <p>
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。
 * 斐波那契数列的定义如下：
 * F(0) = 0, F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/21 10:13
 */
public class Java {
    /**
     * Time O(2^n)
     * Space O(1)
     *
     * @param n 第n项
     * @return 结果
     */
    public int fib01(int n) {
        if (n < 2) {
            return n;
        }
        return fib01(n - 1) + fib01(n - 2);
    }

    /**
     * Time O(n)
     * Space O(n)
     *
     * @param n 第n项
     * @return 结果
     */
    public int fib02(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }

    /**
     * Time O(n)
     * Space O(1)
     *
     * @param n 第n项
     * @return 结果
     */
    public int fib03(int n) {
        if (n < 2) {
            return n;
        }
        int mod = 1000000007;
        int first = 1, second = 0, result;
        for (int i = 2; i <= n; i++) {
            result = (first + second) % mod;
            second = first;
            first = result;
        }
        return first;
    }
}