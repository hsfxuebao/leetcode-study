package leetcode.editor.cn;
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 1275 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution54 {


    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;

        int upperBound = 0, lowerBound = row - 1;
        int leftBound = 0, rightBound = col - 1;

        while (result.size() < row * col) {

            // 从左 向右 遍历
            if (upperBound <= lowerBound) {
                for (int i = leftBound; i <= rightBound; i++) {
                    result.add(matrix[upperBound][i]);
                }
                upperBound++;
            }

            // 从上向下 遍历
            if (leftBound <= rightBound) {
                for (int i = upperBound; i <= lowerBound; i++) {
                    result.add(matrix[i][rightBound]);
                }
                rightBound--;
            }

            // 从 右 向 左  遍历
            if (upperBound <= lowerBound) {
                for (int i = rightBound; i >= leftBound; i--) {
                    result.add(matrix[lowerBound][i]);
                }
                lowerBound--;
            }
            // 从下 向上遍历
            if (leftBound <= rightBound) {
                for (int i = lowerBound; i >= upperBound; i--) {
                    result.add(matrix[i][leftBound]);
                }
                leftBound++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] matrixs = {{1,2,3},{4,5,6}, {7,8,9}};
        System.out.println(spiralOrder(matrixs));

    }

}
//leetcode submit region end(Prohibit modification and deletion)
