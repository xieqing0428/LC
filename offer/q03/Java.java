package cn.alessa0.lc.offer.q03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * <p>
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/11 18:48
 */
public class Java {

    /**
     * Time  O(nlogn)
     * Space O(1)
     *
     * @param nums INPUT[2, 3, 1, 0, 2, 5, 3]
     * @return int
     */
    public int findRepeatNumber01(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * Time  O(n)
     * Space O(n)
     *
     * @param nums INPUT[2, 3, 1, 0, 2, 5, 3]
     * @return int
     */
    public int findRepeatNumber02(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        Set<Integer> resultSet = new HashSet<>();
        for (int i : nums) {
            if (!resultSet.add(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Time  O(n)
     * Space O(1)
     *
     * @param nums INPUT[2, 3, 1, 0, 2, 5, 3]
     * @return int
     */
    public int findRepeatNumber03(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}