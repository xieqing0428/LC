package cn.alessa0.lc.offer.q13;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * <p>
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0]的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * <p>
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格[35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/3/2 18:33
 */
public class Java {
    int m, n, k;
    boolean[][] visited;

    /**
     * Time  O(mn)
     * Space O(mn)
     *
     * @param m 横坐标 m <= 100
     * @param n 纵坐标 1 <= n
     * @param k 总数 0 <= k <= 20
     * @return 结果
     */
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }

    public int dfs(int i, int j, int si, int sj) {
        if (i >= m || j >= n || k < si + sj || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ?
                sj + 1 : sj - 8);
    }
}