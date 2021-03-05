package cn.alessa0.lc.offer.q19;

/**
 * 剑指 Offer 19. 正则表达式匹配
 * <p>
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * <p>
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 *
 * @author AlesArraya0
 * @version 0.0.1
 * @since 2021/3/5 09:01
 */
public class Java {
    int[][] cache;

    /**
     * Time  O(mn)
     * Space O(mn)
     *
     * @param s 字符串:可能为空，且只包含从 a-z 的小写字母。
     * @param p 模式:可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'
     * @return 结果--
     */
    public boolean isMatch(String s, String p) {
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        cache = new int[s.length() + 1][p.length() + 1];
        return dfs(sArray, 0, pArray, 0);
    }

    public boolean dfs(char[] sArray, int i, char[] pArray, int j) {
        if (cache[i][j] != 0) {
            return cache[i][j] == 1;
        }
        if (j == pArray.length) {
            cache[i][j] = i == sArray.length ? 1 : -1;
            return i == sArray.length;
        }
        boolean first = (i < sArray.length) && (pArray[j] == '.' || pArray[j] == sArray[i]);
        boolean match;
        if (j + 1 < pArray.length && pArray[j + 1] == '*') {
            match = first ? dfs(sArray, i + 1, pArray, j) || dfs(sArray, i, pArray, j + 2) : dfs(sArray, i, pArray,
                    j + 2);
        } else {
            match = first && dfs(sArray, i + 1, pArray, j + 1);
        }
        cache[i][j] = match ? 1 : -1;
        return match;
    }
}