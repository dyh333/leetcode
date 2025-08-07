/*
 * @lc app=leetcode.cn id=304 lang=java
 * @lcpr version=30202
 *
 * [304] 二维区域和检索 - 矩阵不可变
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RangeSumQuery2DImmutable {

    // @lc code=start
    class NumMatrix {
        // preSum[i][j] 记录矩阵 [0, 0, i-1, j-1] 的元素和
        private int[][] preSum;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            // 构造前缀和矩阵
            preSum = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    // 计算每个矩阵 [0, 0, i, j] 的元素和
                    // dingyihui: 可以想象成增加了一个虚拟的第一行和第一列，数值都是0，方便计算
                    preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i - 1][j - 1] - preSum[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            // 计算矩阵 [row1, col1, row2, col2] 的元素和
            return preSum[row2 + 1][col2 + 1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1] + preSum[row1][col1];
        }
    }

    /**
     * Your NumMatrix object will be instantiated and called as such:
     * NumMatrix obj = new NumMatrix(matrix);
     * int param_1 = obj.sumRegion(row1,col1,row2,col2);
     */
    // @lc code=end

    public static void main(String[] args) {
        int[][] matrix = {
                { 3, 0, 1, 4, 2 },
                { 5, 6, 3, 2, 1 },
                { 1, 2, 0, 1, 5 },
                { 4, 1, 0, 1, 7 },
                { 1, 0, 3, 0, 5 }
        };
        NumMatrix solution = new RangeSumQuery2DImmutable().new NumMatrix(matrix);
        // put your test code here
        System.out.println(solution.sumRegion(2, 1, 4, 3)); // Output: 8
        System.out.println(solution.sumRegion(1, 1, 2, 2)); // Output: 11
        System.out.println(solution.sumRegion(1, 2, 2, 4)); // Output: 12
    }
}

/*
 * // @lcpr case=start
 * //
 * ["NumMatrix","sumRegion","sumRegion","sumRegion"]\n[[[[3,0,1,4,2],[5,6,3,2,1]
 * ,[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]\n
 * // @lcpr case=end
 * 
 */
