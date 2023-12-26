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
// 👍 1561, 👎 0 
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
 * 2023-12-19 14:18:40 
 */
class P54_SpiralMatrix{
    public static void main(String[] args) {
        Solution solution = new P54_SpiralMatrix().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null) {
            return res;
        }
        
        int row = matrix.length, col = matrix[0].length;
        int left = 0, right = col-1, upper = 0, lower = row - 1;

        while (res.size() < row * col) {

            // 第一行
            if (upper <= lower) {
                for (int i = left; i <= right; i++) {
                    res.add(matrix[upper][i]);
                }
                upper++;
            }

            // 最后一列
            if (left <= right) {
                for (int i = upper; i <= lower; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
            }

            // 最后一行
            if (upper <= lower) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[lower][i]);
                }
                lower--;
            }
            // 第一列
            if (left <= right) {
                for (int i = lower; i >= upper; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }

        }
        return res;
        
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
