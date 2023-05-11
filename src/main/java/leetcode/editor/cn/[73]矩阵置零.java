package leetcode.editor.cn;

//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
//输出：[[1,0,1],[0,0,0],[1,0,1]]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[0].length 
// 1 <= m, n <= 200 
// -2³¹ <= matrix[i][j] <= 2³¹ - 1 
// 
//
// 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。 
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。 
// 你能想出一个仅使用常量空间的解决方案吗？ 
// 
//
// Related Topics数组 | 哈希表 | 矩阵 
//
// 👍 874, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 矩阵置零
 *
 * @author hsfxuebao
 * 2023-05-10 17:31:43 
 */
class P73_SetMatrixZeroes{
    public static void main(String[] args) {
        Solution solution = new P73_SetMatrixZeroes().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * 空间复杂度 o(2)
         * 时间复杂度 o(mn)
         */
        public void setZeroes(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            // 使用第一行 第一列记录行和列是有有0
            // 第一行 和 第一列 使用两个标记位 记录 是否有0
            boolean zeroRow = false, zeroCol = false;
            // 先计算第一行 第一列是否有0
            for (int i = 0; i < m; i++) {
                if (matrix[i][0] == 0) {
                    zeroCol = true;
                }
            }
            for (int j = 0; j < n; j++) {
                if (matrix[0][j] == 0) {
                    zeroRow = true;
                }
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[0][j] = matrix[i][0] = 0;
                    }
                }
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }

            if (zeroRow) {
                for (int j = 0; j < n; j++) {
                    matrix[0][j] = 0;
                }
            }
            if (zeroCol) {
                for (int i = 0; i < m; i++) {
                    matrix[i][0] = 0;
                }
            }
            

        }

        /**
         * 空间复杂度 o(m+n)
         * 时间复杂度 o(mn)
         */
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 记录每一行是否有0
        boolean[] rowFlag = new boolean[m];
        // 记录每一列是否有0
        boolean[] colFlag = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowFlag[i] = colFlag[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowFlag[i] || colFlag[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
