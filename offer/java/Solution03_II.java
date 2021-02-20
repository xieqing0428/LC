package cn.alessa0.lc.offer.java;

/**
 * 剑指 Offer 03 Part II. 不修改数组找出重复的数字
 * <p>
 * 在一个长度为 n+1 的数组里的所有数字都在 1～n 的范围内，所以数组中至少有一个数字是重复的。
 * 请找出数组中任意一个重复的数字，但不能修改输入的数组。
 * 例如，如果输入长度为8的数组{2，3，5，4，3，2，6，7}，那么对应的输出是重复的数字2或者3。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/11 18:48
 */
public class Solution03_II {
    /**
     * Time  O(n)
     * Space O(n)
     *
     * @param nums INPUT
     * @return int
     */
    public int findRepeatNumber01(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        int[] temp = new int[nums.length];
        for (int num : nums) {
            if (temp[num] == 1) {
                return num;
            }
            temp[num] = 1;
        }
        return -1;
    }

    /**
     * Time  O(nlogn)
     * Space O(1)
     *
     * @param nums INPUT
     * @return int
     */
    public int findRepeatNumber02(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        int start = 1;
        int end = nums.length - 1;
        while (end >= start) {
            int middle = (start + end) >> 1;
            int count = countRange(nums, start, middle);
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > middle - start + 1) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    private int countRange(int[] nums, int start, int middle) {
        int count = 0;
        for (int num : nums) {
            if (num >= start && num <= middle) {
                count++;
            }
        }
        return count;
    }

}