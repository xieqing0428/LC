package cn.alessa0.lc.offer.q05;

/**
 * 剑指 Offer 05. 替换空格
 * <p>
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/12 17:18
 */
public class Java {
    public String replaceSpace01(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        return s.replace(" ", "%20");
    }

    /**
     * Time  O(n)
     * Space O(n)
     *
     * @param s INPUT
     * @return java.lang.String
     */
    public String replaceSpace02(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        return new String(array, 0, size);
    }
}