package leetcode.editor.cn;

//给你一个满足下述两条属性的 m x n 整数矩阵： 
//
// 
// 每行中的整数从左到右按非递减顺序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
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
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
//
// Related Topics数组 | 二分查找 | 矩阵 
//
// 👍 841, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 搜索二维矩阵
 *
 * @author hsfxuebao
 * 2023-09-11 21:29:10 
 */
class P74_SearchA2dMatrix{
    public static void main(String[] args) {
        Solution solution = new P74_SearchA2dMatrix().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // 将二维数组 转换成一维数组
        // row = 位置 / 列的长度， col = 位置 % 列的长度
        int colLen = matrix[0].length;
        int rowLen = matrix.length;

        int left = 0, right = rowLen * colLen - 1;
        while (left <= right) {

            int mid = left + (right - left)/2;
            int row = mid / colLen;
            int col = mid % colLen;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                right = mid - 1;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            }
        }
        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
