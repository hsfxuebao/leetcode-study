package leetcode.editor.cn;

//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性： 
//
// 
// 每行的元素从左到右升序排列。 
// 每列的元素从上到下升序排列。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 5
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 20
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= n, m <= 300 
// -10⁹ <= matrix[i][j] <= 10⁹ 
// 每行的所有元素从左到右升序排列 
// 每列的所有元素从上到下升序排列 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics数组 | 二分查找 | 分治 | 矩阵 
//
// 👍 1250, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 搜索二维矩阵 II
 *
 * @author hsfxuebao
 * 2023-04-02 09:46:13 
 */
class P240_SearchA2dMatrixIi{
    public static void main(String[] args) {
        Solution solution = new P240_SearchA2dMatrixIi().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }

        // 初始化在 右上角，大于target 往下移动，小于target往左移动
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            }

        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
