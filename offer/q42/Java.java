package cn.alessa0.lc.offer.q42;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * <p>
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/13 18:12
 */
public class Java {
    /**
     * Time  O(n)
     * Space O(1)
     *
     * @param nums 1 <= arr.length <= 10<sup>5</sup>;-100 <= arr[i] <= 100
     * @return max
     */
    public int maxSubArray(int[] nums) {
        int max = -101;
        int cur = 0;
        for (int num : nums) {
            cur += num;
            if (cur < num) {
                cur = num;
            }
            if (max < cur) {
                max = cur;
            }
        }
        return max;
    }
}