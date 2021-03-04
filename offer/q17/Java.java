package cn.alessa0.lc.offer.q17;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 * <p>
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/3/4 09:24
 */
public class Java {
    /**
     * Time  O(10^n)
     * Space O(10^n)
     *
     * @param n 入参
     * @return 结果
     */
    public int[] printNumbers(int n) {
        int end = (int) Math.pow(10, n) - 1;
        int[] res = new int[end];
        for (int i = 0; i < end; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    public void printBigNumbers(int n) {
        StringBuilder str = new StringBuilder();
        // 将str初始化为n个'0'字符组成的字符串
        str.append("0".repeat(Math.max(0, n)));
        while (!increment(str)) {
            // 去掉左侧的0
            int index = 0;
            while (index < str.length() && str.charAt(index) == '0') {
                index++;
            }
            System.out.println(str.substring(index));
        }
    }

    public boolean increment(StringBuilder str) {
        boolean isOverflow = false;
        for (int i = str.length() - 1; i >= 0; i--) {
            char s = (char) (str.charAt(i) + 1);
            // 如果s大于'9'则发生进位
            if (s > '9') {
                str.replace(i, i + 1, "0");
                if (i == 0) {
                    isOverflow = true;
                }
                // 没发生进位则跳出for循环
            } else {
                str.replace(i, i + 1, String.valueOf(s));
                break;
            }
        }
        return isOverflow;
    }
}