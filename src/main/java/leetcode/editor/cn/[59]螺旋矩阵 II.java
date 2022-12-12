package leetcode.editor.cn;
//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 883 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution59 {

    public int[][] generateMatrix(int n) {

        int num = 1;
        int up = 0, down = n - 1;
        int left = 0, right = n - 1;

        int[][] matrix = new int[n][n];

        while (num <= n * n) {

            // 从左到右 遍历
            if (up <= down) {
                for (int i = left; i <= right; i++) {
                    matrix[up][i] = num++;
                }
                up++;
            }

            // 从上到下 遍历
            if (left <= right) {
                for (int i = up; i <= down; i++) {
                    matrix[i][right] = num++;
                }
                right--;
            }

            // 从 右 向左  遍历
            if (up <= down) {
                for (int i = right; i >= left; i--) {
                    matrix[down][i] = num++;
                }
                down--;
            }
            // 从下向上 遍历
            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }
        return matrix;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
