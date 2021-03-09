package cn.alessa0.lc.offer.q29;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * <p>
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/13 18:12
 */
public class Java {
    /**
     * @param matrix 0 <= matrix.length <= 100;0 <= matrix[i].length <= 100
     * @return 结果
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new int[]{};
        }
        int start = 0;
        int index = 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int[] res = new int[row * column];
        while (row > 2 * start && column > 2 * start) {
            index = spiralOrder(matrix, start, res, index);
            start++;
        }
        return res;
    }

    private int spiralOrder(int[][] matrix, int start, int[] res, int index) {
        int endRow = matrix.length - 1 - start;
        int endColumn = matrix[0].length - 1 - start;

        for (int i = start; i <= endColumn; i++) {
            res[index++] = matrix[start][i];
        }
        if (start < endRow) {
            for (int i = start + 1; i <= endRow; i++) {
                res[index++] = matrix[i][endColumn];
            }
        }
        if (start < endRow && start < endColumn) {
            for (int i = endColumn - 1; i >= start; i--) {
                res[index++] = matrix[endRow][i];
            }
        }
        if (start < endRow - 1 && start < endColumn) {
            for (int i = endRow - 1; i > start; i--) {
                res[index++] = matrix[i][start];
            }
        }
        return index;
    }
}