package leetcode.editor.cn;

//一个机器人位于一个
// m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 
//
// 示例 1： 
// 
// 
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
//
// 示例 2： 
// 
// 
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == obstacleGrid.length 
// n == obstacleGrid[i].length 
// 1 <= m, n <= 100 
// obstacleGrid[i][j] 为 0 或 1 
// 
//
// Related Topics数组 | 动态规划 | 矩阵 
//
// 👍 1071, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

/**
 * 不同路径 II
 *
 * @author hsfxuebao
 * 2023-06-27 20:49:50 
 */
class P63_UniquePathsIi{
    public static void main(String[] args) {
        Solution solution = new P63_UniquePathsIi().new Solution();
        
    }  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        if (m == 1 && n == 1) {
            return 1;
        }

        // 以dp(i,j) 到右下角有多少种路径
        int[][] dp = new int[m][n];

        // base case
        // 最后一行
        for (int j = n-2; j >= 0; j--) {
            if (obstacleGrid[m - 1][j] == 1) {
                break;
            }
            dp[m-1][j] = 1;
        }
        // 最后一列
        for (int i = m-2; i >= 0; i--) {
            if (obstacleGrid[i][n-1] == 1) {
                break;
            }
            dp[i][n-1] = 1;
        }
        // 状态转移方程
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
