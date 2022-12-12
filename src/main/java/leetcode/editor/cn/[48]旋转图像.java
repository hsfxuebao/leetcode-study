package leetcode.editor.cn;
//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
//
// 
// Related Topics 数组 数学 矩阵 
// 👍 1499 👎 0


import static jdk.nashorn.internal.objects.NativeArray.reverse;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 顺时针旋转数组
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // 左上-右下 对称
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 每一行 反转
        for (int i = 0; i < row; i++) {
           reverse(matrix[i]);
        }
    }

    private void reverse(int[] matrix) {
        int left = 0;
        int right = matrix.length - 1;

        while (left < right) {
            int temp = matrix[left];
            matrix[left] = matrix[right];
            matrix[right] = temp;
            left++;
            right--;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
