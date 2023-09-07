package leetcode.editor.cn;

//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
//
// Related Topics数组 | 动态规划 | 矩阵 
//
// 👍 1486, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 最小路径和
 *
 * @author hsfxuebao
 * 2023-04-22 17:57:10 
 */
class P64_MinimumPathSum{
    public static void main(String[] args) {
        Solution solution = new P64_MinimumPathSum().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
       int m = grid.length;
       int n = grid[0].length;

       int[][] dp = new int[m][n];
       // base case
        // 最后一行
        dp[m-1][n-1] = grid[m-1][n-1];
        for (int j = n-2; j >= 0; j--) {
            dp[m-1][j] = dp[m-1][j+1] + grid[m-1][j];
        }
        // 最后一列
        for (int i = m-2; i >= 0; i--) {
            dp[i][n-1] = dp[i+1][n-1] + grid[i][n-1];
        }

        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
            }

        }
        return dp[0][0];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
