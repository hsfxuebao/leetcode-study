package leetcode.editor.cn;

//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
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
// 👍 787, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 搜索二维矩阵
 *
 * @author hsfxuebao
 * 2023-04-02 09:53:03 
 */
class P74_SearchA2dMatrix{
    public static void main(String[] args) {
        Solution solution = new P74_SearchA2dMatrix().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        // 二维矩阵  转成一维数组
        int left = 0, right = m*n;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (getNumber(mid, matrix) == target) {
                return true;
            } else if (getNumber(mid, matrix) > target) {
                right = mid;
            } else if (getNumber(mid, matrix) < target) {
                left = mid + 1;
            }
        }
        return false;
    }

        private int getNumber(int mid, int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int row = mid / n, col = mid % n;
            return matrix[row][col];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
 
}
