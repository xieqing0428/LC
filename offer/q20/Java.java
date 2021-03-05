package cn.alessa0.lc.offer.q20;

/**
 * 剑指 Offer 20. 表示数值的字符串
 * <p>
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * <p>
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/3/5 09:01
 */
public class Java {
    /**
     * Time  O(n)
     * Space O(1)
     *
     * @param s 字符串
     * @return 结果
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        //去掉首位空格
        s = s.trim();
        boolean num = false;
        boolean dot = false;
        boolean e = false;
        for (int i = 0; i < s.length(); i++) {
            // 判定为数字，则标记num
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = true;
                continue;
            }
            // 判定为.  需要没出现过.并且没出现过e
            if (s.charAt(i) == '.' && !dot && !e) {
                dot = true;
                continue;
            }
            // 判定为e，需要没出现过e，并且出过数字了
            if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !e && num) {
                e = true;
                // 为了避免123e这种请求，出现e之后就标志为false
                num = false;
                continue;
            }
            // 判定为+-符号，只能出现在第一位或者紧接e后面
            if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {
                continue;
            }
            //其他情况，都是非法的
            return false;
        }
        return num;
    }
}