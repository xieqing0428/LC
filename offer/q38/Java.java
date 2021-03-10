package cn.alessa0.lc.offer.q38;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 38. 字符串的排列
 * <p>
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/13 18:12
 */
public class Java {
    private char[] chars;
    private List<String> res;

    /**
     * Time  O(n!n)
     * Space O(n)
     *
     * @param s 1 <= s 的长度 <= 8
     * @return 序列
     */
    public String[] permutation(String s) {
        chars = s.toCharArray();
        res = new ArrayList<>();
        dfs(0);
        return res.toArray(new String[0]);
    }

    private void dfs(int idx) {
        if (idx == chars.length - 1) {
            res.add(String.valueOf(chars));
            return;
        }
        main:
        for (int i = idx; i < chars.length; i++) {
            for (int j = idx; j < i; j++) {
                if (chars[i] == chars[j]) {
                    continue main;
                }
            }
            swap(i, idx);
            dfs(idx + 1);
            swap(i, idx);
        }
    }

    private void swap(int i, int idx) {
        if (i == idx) {
            return;
        }
        char tmp = chars[i];
        chars[i] = chars[idx];
        chars[idx] = tmp;
    }
}