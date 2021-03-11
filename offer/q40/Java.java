package cn.alessa0.lc.offer.q40;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 40. 最小的k个数
 * <p>
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * <p>
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/13 18:12
 */
public class Java {
    /**
     * Time  O(nlogn)
     * Space O(logn)
     *
     * @param arr 0 <= arr[i] <= 10000
     * @param k   0 <= k <= arr.length <= 10000
     * @return 结果
     */
    public int[] getLeastNumbers01(int[] arr, int k) {
        int[] vec = new int[k];
        Arrays.sort(arr);
        if (k >= 0) {
            System.arraycopy(arr, 0, vec, 0, k);
        }
        return vec;
    }

    /**
     * Time  O(nlogn)
     * Space O(k)
     *
     * @param arr 0 <= arr[i] <= 10000
     * @param k   0 <= k <= arr.length <= 10000
     * @return 结果
     */
    public int[] getLeastNumbers02(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (arr == null || arr.length == k) {
            return arr;
        }
        PriorityQueue<Integer> max = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int i : arr) {
            if (max.size() < k) {
                max.add(i);
            } else if (max.peek() != null && max.peek() > i) {
                max.poll();
                max.add(i);
            }
        }
        return max.stream().mapToInt(x -> x).toArray();
    }

    /**
     * Time  O(n)
     * Space O(k)
     *
     * @param arr 0 <= arr[i] <= 10000
     * @param k   0 <= k <= arr.length <= 10000
     * @return 结果
     */
    public int[] getLeastNumbers03(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }
        return quickSort(arr, k, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int k, int l, int r) {
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) {
                j--;
            }
            while (i < j && arr[i] <= arr[l]) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, i, l);
        if (i > k) {
            return quickSort(arr, k, l, i - 1);
        }
        if (i < k) {
            return quickSort(arr, k, i + 1, r);
        }
        return Arrays.copyOf(arr, k);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}