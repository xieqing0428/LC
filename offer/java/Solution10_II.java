package cn.alessa0.lc.offer.java;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/21 10:13
 */
public class Solution10_II {
    /**
     * Time O(2^n)
     * Space O(1)
     *
     * @param n 第n项
     * @return 结果
     */
    public int numWays01(int n) {
        if (n < 2) {
            return 1;
        }
        return numWays01(n - 1) + numWays01(n - 2);
    }

    /**
     * Time O(n)
     * Space O(n)
     *
     * @param n 第n项
     * @return 结果
     */
    public int numWays02(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
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
    public int numWays03(int n) {
        int mod = 1000000007;
        int first = 1, second = 1, result;
        for (int i = 2; i <= n; i++) {
            result = (first + second) % mod;
            second = first;
            first = result;
        }
        return first;
    }
}