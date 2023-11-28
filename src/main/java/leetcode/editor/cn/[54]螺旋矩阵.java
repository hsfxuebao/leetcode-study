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
//
// Related Topics数组 | 矩阵 | 模拟 
//
// 👍 1545, 👎 0 
//
//
//
//

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 *
 * @author hsfxuebao
 * 2023-11-28 19:47:16 
 */
class P54_SpiralMatrix{
    public static void main(String[] args) {
        Solution solution = new P54_SpiralMatrix().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int row = matrix.length, col = matrix[0].length;
        int upperBound = 0, lowerBound = row - 1;
        int leftBound = 0, rightBound = col - 1;
        List<Integer> res = new ArrayList<>();
        while (res.size() < row * col) {


            // 第一行 向右遍历
            if (upperBound <= lowerBound) {
                for (int i = leftBound; i <= rightBound; i++) {
                    res.add(matrix[upperBound][i]);
                }
                upperBound++;
            }
            // 最后一列 从上到下遍历
            if (leftBound <= rightBound) {
                for (int i = upperBound; i <= lowerBound; i++) {
                    res.add(matrix[i][rightBound]);
                }
                rightBound--;
            }
            // 最后一行，从右向左遍历
            if (upperBound <= lowerBound) {
                for (int j = rightBound; j >= leftBound; j--) {
                    res.add(matrix[lowerBound][j]);
                }
                lowerBound--;
            }
            if (leftBound <= rightBound) {
                for (int i = lowerBound; i >= upperBound; i--) {
                    res.add(matrix[i][leftBound]);
                }
                leftBound++;
            }


        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
